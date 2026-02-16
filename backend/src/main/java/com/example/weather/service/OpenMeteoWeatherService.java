package com.example.weather.service;

import com.example.weather.dto.GeocodingResult;
import com.example.weather.dto.WeatherResponse;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class OpenMeteoWeatherService implements WeatherService {

    private static final String GEOCODE_URL = "https://geocoding-api.open-meteo.com/v1/search";
    private static final String FORECAST_URL = "https://api.open-meteo.com/v1/forecast";

    private final RestClient restClient;

    public OpenMeteoWeatherService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    @Override
    public GeocodingResult findCoordinatesByCity(String city) {
        String encoded = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String url = GEOCODE_URL + "?name=" + encoded + "&count=1&language=en&format=json";

        JsonNode body = getJson(url);
        JsonNode results = body.path("results");
        if (!results.isArray() || results.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "City not found: " + city);
        }

        JsonNode first = results.get(0);
        return new GeocodingResult(
                first.path("name").asText(city),
                first.path("latitude").asDouble(),
                first.path("longitude").asDouble()
        );
    }

    @Override
    public WeatherResponse getWeatherByCoordinates(double latitude, double longitude, String locationName) {
        String url = FORECAST_URL +
                "?latitude=" + latitude +
                "&longitude=" + longitude +
                "&current=temperature_2m,wind_speed_10m,weather_code";

        JsonNode body = getJson(url);
        JsonNode current = body.path("current");
        if (current.isMissingNode() || current.isNull()) {
            throw new ResponseStatusException(BAD_GATEWAY, "No current weather data returned");
        }

        String resolvedName = (locationName == null || locationName.isBlank())
                ? "Lat " + latitude + ", Lon " + longitude
                : locationName;

        return new WeatherResponse(
                resolvedName,
                latitude,
                longitude,
                current.path("temperature_2m").asDouble(),
                current.path("wind_speed_10m").asDouble(),
                current.path("weather_code").asInt(),
                current.path("time").asText()
        );
    }

    @Override
    public WeatherResponse getWeatherByCity(String city) {
        GeocodingResult geocoding = findCoordinatesByCity(city);
        return getWeatherByCoordinates(geocoding.latitude(), geocoding.longitude(), geocoding.name());
    }

    private JsonNode getJson(String url) {
        try {
            return restClient.get()
                    .uri(url)
                    .retrieve()
                    .body(JsonNode.class);
        } catch (Exception ex) {
            throw new ResponseStatusException(BAD_GATEWAY, "Upstream weather service unavailable", ex);
        }
    }
}
