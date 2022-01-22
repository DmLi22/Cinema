package by.shag.litvinov.jpa.repository;

import by.shag.litvinov.jpa.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.Instant;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer>, JpaSpecificationExecutor<Schedule> {

    List<Schedule> findByStartDateTimeBetween(Instant minStartDateTime, Instant maxStartDateTime);

    List<Schedule> findByEndDateTimeBetween(Instant minEndDateTime, Instant maxEndDateTime);
}
