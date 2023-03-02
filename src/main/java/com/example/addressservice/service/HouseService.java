package com.example.addressservice.service;

import com.example.addressservice.dto.CityStreetHouseDto;
import com.example.addressservice.dto.HousesApartmentsAmountDto;
import com.example.addressservice.entity.House;

import java.util.List;
import java.util.Optional;

public interface HouseService {

    List<HousesApartmentsAmountDto> getHousesCity(String name);

    List<HousesApartmentsAmountDto> getHousesStreet(String name);

    Optional<Integer> getId(CityStreetHouseDto cityStreetHouseDto);
}
