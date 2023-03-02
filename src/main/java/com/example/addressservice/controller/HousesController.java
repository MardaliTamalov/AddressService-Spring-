package com.example.addressservice.controller;

import com.example.addressservice.dto.CityStreetHouseDto;
import com.example.addressservice.dto.MessageDto;
import com.example.addressservice.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/houses")
@RequiredArgsConstructor

public class HousesController {
    private final HouseService houseService;

    @GetMapping(params= {"city"})
    public ResponseEntity<?> getHousesCity(@RequestParam String city) {
        return ResponseEntity.status(HttpStatus.OK).body(houseService.getHousesCity(city));
    }

    @GetMapping(params={"street"})
    public ResponseEntity<?> getHousesStreet(@RequestParam String street) {
        return ResponseEntity.status(HttpStatus.OK).body(houseService.getHousesStreet(street));
    }

    @GetMapping()
    public ResponseEntity<?> findHouses(@RequestBody CityStreetHouseDto cityStreetHouseDto) {
        if (houseService.getId(cityStreetHouseDto).isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDto("не существует данного дома"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(houseService.getId(cityStreetHouseDto));
    }
}
