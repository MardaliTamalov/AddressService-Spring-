package com.example.addressservice.controller;

import com.example.addressservice.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/streets")
@RequiredArgsConstructor

public class StreetsController {
    private final StreetService streetService;
    @GetMapping()
    public ResponseEntity<?> getStreets(@RequestParam("name") String name){
        return ResponseEntity.status(HttpStatus.OK).body(streetService.getStreets(name));
    }
}
