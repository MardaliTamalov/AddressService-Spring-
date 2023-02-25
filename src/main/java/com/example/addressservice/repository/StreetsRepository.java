package com.example.addressservice.repository;

import com.example.addressservice.dto.StreetsHousesAmountDto;
import com.example.addressservice.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StreetsRepository extends JpaRepository<Street, Integer> {

    @Query(value = """
            select new com.example.addressservice.dto.StreetsHousesAmountDto(s.name, count(h.id))
            from House h
             join Street s on s.id = h.id
            join City c on s.id = c.id
            where c.name =: name
            group by s.name
            """)
    List<StreetsHousesAmountDto> getStreets(String name);
}
