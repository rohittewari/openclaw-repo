package com.example.weather.service;

import com.example.weather.dto.GeocodingResult;
import com.example.weather.dto.WeatherResponse;

public interface WeatherService {
    GeocodingResult findCoordinatesByCity(String city);

    WeatherResponse getWeatherByCoordinates(double latitude, double longitude, String locationName);

    WeatherResponse getWeatherByCity(String city);
}
