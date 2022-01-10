package by.shag.litvinov.jpa.repository;

import by.shag.litvinov.jpa.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface HallRepository extends JpaRepository<Hall, Integer>, JpaSpecificationExecutor<Hall> {

    List<Hall> findByCinemaNameStartingWithIgnoreCase(String cinemaName);

    List<Hall> findByNumberOfSeatsBetween(Integer minNumberOfSeats, Integer maxNumberOfSeats);

    List<Hall> findByNumberOfPersonBetween(Integer minNumberOfPerson, Integer maxNumberOfPerson);
}
