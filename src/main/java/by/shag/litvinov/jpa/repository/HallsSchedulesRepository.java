package by.shag.litvinov.jpa.repository;

import by.shag.litvinov.jpa.model.HallsSchedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface HallsSchedulesRepository extends JpaRepository<HallsSchedules, Integer>, JpaSpecificationExecutor<HallsSchedules> {

    Optional<HallsSchedules> findByHall_IdAndSchedule_Id(Integer hallId, Integer scheduledId);
}
