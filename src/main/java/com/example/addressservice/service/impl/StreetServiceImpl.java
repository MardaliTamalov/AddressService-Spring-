package com.example.addressservice.service.impl;

import com.example.addressservice.dto.StreetsHousesAmountDto;
import com.example.addressservice.repository.StreetsRepository;
import com.example.addressservice.service.StreetService;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StreetServiceImpl implements StreetService {
private final StreetsRepository streetsRepository;

    @Override
    @Transactional
    public List<StreetsHousesAmountDto> getStreets(String name) {
        return streetsRepository.getStreets(name);
    }
}
