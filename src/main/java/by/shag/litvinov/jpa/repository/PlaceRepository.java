package by.shag.litvinov.jpa.repository;

import by.shag.litvinov.jpa.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Integer>, JpaSpecificationExecutor<Place> {

    List<Place> findByArmchairTypeStartingWithOrderByArmchairTypeAsc(String armchairType);

    List<Place> findByRowBetweenOrderByRow(Integer minRow, Integer maxRow);

    List<Place> findByPlaceBetweenOrderByPlace(Integer minPlace, Integer maxPlace);

    Optional<Place> findByRowAndPlaceOrderByArmchairType(Integer row, Integer place);
}
