package com.example.weather.dto;

public record WeatherResponse(
        String locationName,
        double latitude,
        double longitude,
        double temperatureC,
        double windSpeedKph,
        int weatherCode,
        String timestamp
) {
}
