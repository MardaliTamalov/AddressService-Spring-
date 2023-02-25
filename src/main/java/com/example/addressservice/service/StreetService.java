package com.example.addressservice.service;

import com.example.addressservice.dto.StreetsHousesAmountDto;

import java.util.List;

public interface StreetService {

    List<StreetsHousesAmountDto> getStreets(String name);
}
