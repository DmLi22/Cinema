package by.shag.litvinov.jpa.specification;

import by.shag.litvinov.api.dto.ScheduleSearchCriteriaDto;
import by.shag.litvinov.jpa.model.Schedule;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;

public class ScheduleSpecificationUtils {

    public static Specification<Schedule> equalsMovieId(Integer movieId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("movieId"), movieId);
    }

    public static Specification<Schedule> equalsStartDateTime(Instant startDateTime) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("startDateTime"), startDateTime);
    }

    public static Specification<Schedule> greaterThanMinStartDateTime(Instant minStartDateTime) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("startDateTime"), minStartDateTime);
    }

    public static Specification<Schedule> lessThanMaxStartDateTime(Instant maxStartDateTime) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("startDateTime"), maxStartDateTime);
    }

    public static Specification<Schedule> equalsEndDateTime(Instant endDateTime) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("endDateTime"), endDateTime);
    }

    public static Specification<Schedule> greaterThanMinEndDateTime(Instant minEndDateTime) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("endDateTime"), minEndDateTime);
    }

    public static Specification<Schedule> lessThanMaxEndDateTime(Instant maxEndDateTime) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("endDateTime"), maxEndDateTime);
    }

    public static Specification<Schedule> defaultSpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("id"), 0);
    }

    public static Specification<Schedule> findBySearchCriteria(ScheduleSearchCriteriaDto criteriaDto) {
        Specification<Schedule> specification = defaultSpecification();
        if (criteriaDto == null) {
            return specification;
        }
        if (criteriaDto.getMovieId() != null) {
            specification = specification.and(equalsMovieId(criteriaDto.getMovieId()));
        }
        if (criteriaDto.getStartDateTime() != null) {
            specification = specification.and(equalsStartDateTime(criteriaDto.getStartDateTime()));
        } else {
            if (criteriaDto.getMinStartDateTime() != null) {
                specification = specification.and(greaterThanMinStartDateTime(criteriaDto.getMinStartDateTime()));
            }
            if (criteriaDto.getMaxStartDateTime() != null) {
                specification = specification.and(lessThanMaxStartDateTime(criteriaDto.getMaxStartDateTime()));
            }
        }
        if (criteriaDto.getEndDateTime() != null) {
            specification = specification.and(equalsEndDateTime(criteriaDto.getEndDateTime()));
        } else {
            if (criteriaDto.getMinEndDateTime() != null) {
                specification = specification.and(greaterThanMinEndDateTime(criteriaDto.getMinEndDateTime()));
            }
            if (criteriaDto.getMaxEndDateTime() != null) {
                specification = specification.and(lessThanMaxEndDateTime(criteriaDto.getMaxEndDateTime()));
            }
        }
        return specification;
    }
}
