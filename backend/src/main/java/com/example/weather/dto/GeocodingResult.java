package com.example.weather.dto;

public record GeocodingResult(
        String name,
        double latitude,
        double longitude
) {
}
