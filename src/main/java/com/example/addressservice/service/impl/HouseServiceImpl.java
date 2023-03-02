package com.example.addressservice.service.impl;

import com.example.addressservice.dto.CityStreetHouseDto;
import com.example.addressservice.dto.HousesApartmentsAmountDto;
import com.example.addressservice.repository.HousesRepository;
import com.example.addressservice.service.HouseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class HouseServiceImpl implements HouseService {
    private final HousesRepository housesRepository;

    @Override
    @Transactional
    public List<HousesApartmentsAmountDto> getHousesCity(String name) {
        return housesRepository.getHousesCity(name);
    }

    @Override
    @Transactional
    public List<HousesApartmentsAmountDto> getHousesStreet(String name) {
        return housesRepository.getHousesStreet(name);
    }
    @Override
    @Transactional
    public Optional<Integer> getId(CityStreetHouseDto cityStreetHouseDto) {
        return housesRepository.getId(cityStreetHouseDto.city(), cityStreetHouseDto.street(), cityStreetHouseDto.house());
    }
}
