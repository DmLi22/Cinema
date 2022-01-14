package by.shag.litvinov.jpa.repository;

import by.shag.litvinov.jpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer>, JpaSpecificationExecutor<Address> {

    Optional<Address> findByCountryAndCityAndStreetAndHouseNumber(String country, String city,
                                                                  String street,  Integer houseNumber);


}
