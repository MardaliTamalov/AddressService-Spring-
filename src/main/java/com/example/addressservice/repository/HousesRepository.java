package com.example.addressservice.repository;

import com.example.addressservice.dto.CityStreetHouseDto;
import com.example.addressservice.dto.HousesApartmentsAmountDto;
import com.example.addressservice.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HousesRepository extends JpaRepository<House, Integer> {
@Query(value = """
select new com.example.addressservice.dto.HousesApartmentsAmountDto(h.number, count (a.id))
from Apartment a
join House h on a.id=h.id
join Street s on s.id=h.id
join City c on s.id=c.id
where s.name=:name or c.name=:name
group by h.number
""")
    List<HousesApartmentsAmountDto> getHouses(String name);

@Query(value = """
select  h.id
from House h
join Street s on h.id=s.id
join City c on c.id = s.id
where c.name=:city and s.name=:street and h.number=:house
""")
    Optional<Integer> getId(String city, String street, Integer house);
}
