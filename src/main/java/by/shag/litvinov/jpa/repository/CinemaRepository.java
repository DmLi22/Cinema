package by.shag.litvinov.jpa.repository;

import by.shag.litvinov.jpa.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CinemaRepository extends JpaRepository<Cinema, Integer>, JpaSpecificationExecutor<Cinema> {

    Optional<Cinema> findByNameAndAddress_Id(String name, Integer addressId);
}
