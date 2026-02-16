package com.example.weather.controller;

import com.example.weather.dto.WeatherResponse;
import com.example.weather.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/city")
    public WeatherResponse byCity(@RequestParam String city) {
        return weatherService.getWeatherByCity(city);
    }

    @GetMapping("/coordinates")
    public WeatherResponse byCoordinates(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam(required = false) String name
    ) {
        return weatherService.getWeatherByCoordinates(lat, lon, name);
    }
}
