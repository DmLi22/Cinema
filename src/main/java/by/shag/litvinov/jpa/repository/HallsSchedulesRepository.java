package by.shag.litvinov.jpa.repository;

import by.shag.litvinov.jpa.model.HallsSchedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HallsSchedulesRepository extends JpaRepository<HallsSchedules, Integer>, JpaSpecificationExecutor<HallsSchedules> {
}
