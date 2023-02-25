package com.example.addressservice.controller;

import com.example.addressservice.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor

public class StreetsController {
    private final StreetService streetService;

    @GetMapping("/streets/{name}")
    public ResponseEntity<?> getStreets(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(streetService.getStreets(name));
    }
}
