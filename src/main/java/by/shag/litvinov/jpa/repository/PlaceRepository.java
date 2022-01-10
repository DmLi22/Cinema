package by.shag.litvinov.jpa.repository;

import by.shag.litvinov.jpa.model.ArmchairTypeEnum;
import by.shag.litvinov.jpa.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer>, JpaSpecificationExecutor<Place> {

    List<Place> findByArmchairTypeStartingWith/*IgnoreCase*/(ArmchairTypeEnum armchairType);

    List<Place> findByRowBetween(Integer minRow, Integer maxRow);

    List<Place> findByPlaceBetween(Integer minPlace, Integer maxPlace);
}
