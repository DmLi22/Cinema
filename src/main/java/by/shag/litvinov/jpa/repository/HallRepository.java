package by.shag.litvinov.jpa.repository;

import by.shag.litvinov.jpa.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HallRepository extends JpaRepository<Hall, Integer>, JpaSpecificationExecutor<Hall> {

}
