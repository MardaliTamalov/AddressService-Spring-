package com.example.addressservice.controller;

import com.example.addressservice.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor

public class CitiesController {
    private final CityService cityService;

    @GetMapping()
    public ResponseEntity<?> getCities() {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.getCities());
    }
}