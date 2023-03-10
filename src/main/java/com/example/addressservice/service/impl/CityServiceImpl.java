package com.example.addressservice.service.impl;

import com.example.addressservice.dto.CityHouseAmountDto;
import com.example.addressservice.repository.CitiesRepository;
import com.example.addressservice.service.CityService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CityServiceImpl implements CityService {
    private final CitiesRepository citiesRepository;

    @Override
    @Transactional
    public List<CityHouseAmountDto> getCities() {
        return citiesRepository.getCities();
    }
}
