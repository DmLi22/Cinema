package by.shag.litvinov.jpa.repository;

import by.shag.litvinov.jpa.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlaceRepository extends JpaRepository<Place, Integer>, JpaSpecificationExecutor<Place> {
}
