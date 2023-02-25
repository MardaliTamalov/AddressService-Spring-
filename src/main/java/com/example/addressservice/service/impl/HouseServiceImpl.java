package com.example.addressservice.service.impl;

import com.example.addressservice.dto.CityStreetHouseDto;
import com.example.addressservice.dto.HousesApartmentsAmountDto;
import com.example.addressservice.entity.House;
import com.example.addressservice.repository.HousesRepository;
import com.example.addressservice.service.HouseService;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class HouseServiceImpl implements HouseService {

    private final HousesRepository housesRepository;

    @Override
    @Transactional
    public List<HousesApartmentsAmountDto> getHouses(String name) {
        return housesRepository.getHouses(name);
    }

    @Override
    @Transactional
    public Optional<Integer> getId(CityStreetHouseDto cityStreetHouseDto) {
    /**    if(housesRepository.getId(cityStreetHouseDto).isEmpty()){
            System.out.println("не существует данного дома");
            return null;
        }**/

        return housesRepository.getId(cityStreetHouseDto.city(), cityStreetHouseDto.street(), cityStreetHouseDto.house());
    }
}
