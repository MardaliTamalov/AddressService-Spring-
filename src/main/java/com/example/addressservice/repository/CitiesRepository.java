package com.example.addressservice.repository;

import com.example.addressservice.dto.CityHouseAmountDto;
import com.example.addressservice.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CitiesRepository extends JpaRepository<City, Integer> {
    @Query(value = """
            select new com.example.addressservice.dto.CityHouseAmountDto(c.name, count(h.id))
            from City c
             join Street s on c.id= s.city.id
             join House h on s.id = h.street.id
            group by c.name

            """)
    List<CityHouseAmountDto> getCities();
}
