package com.example.addressservice.controller;

import com.example.addressservice.dto.CityStreetHouseDto;
import com.example.addressservice.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@RequiredArgsConstructor

public class HousesController {
    private final HouseService houseService;

    @GetMapping("/houses/{name}")
    public ResponseEntity<?> getHouses(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(houseService.getHouses(name));
    }

    @GetMapping("/id")
    public ResponseEntity<?> getHouses(@RequestParam CityStreetHouseDto cityStreetHouseDto){
        return ResponseEntity.status(HttpStatus.OK).body(houseService.getId(cityStreetHouseDto));
    }
}
