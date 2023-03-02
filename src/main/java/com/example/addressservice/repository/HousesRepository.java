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
select new com.example.addressservice.dto.HousesApartmentsAmountDto(c.name,s.name, h.number, count (a.id))
from House h 
join Apartment a on a.house_id.id = h.id
join Street s on s.id=h.street.id
join City c on c.id = s.city.id
where c.name=:name 
group by h.number, s.name, c.name
""")
    List<HousesApartmentsAmountDto> getHousesCity(String name);


    @Query(value = """
select new com.example.addressservice.dto.HousesApartmentsAmountDto(c.name,s.name, h.number, count (a.id))
from House h
join Apartment a on a.house_id.id = h.id
join Street s on s.id=h.street.id
join City c on c.id = s.city.id
where s.name=:name 
group by h.number, s.name, c.name
""")
    List<HousesApartmentsAmountDto> getHousesStreet(String name);

@Query(value = """
select  h.id
from House h
join Street s on h.street.id =s.id
join City c on c.id = s.city.id
where c.name=:city and s.name=:street and h.number=:number

""")
    Optional<Integer> getId(String city, String street, String number);
}
