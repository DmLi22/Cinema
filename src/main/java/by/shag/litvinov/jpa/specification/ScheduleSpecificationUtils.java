package by.shag.litvinov.jpa.specification;

import by.shag.litvinov.api.dto.ScheduleSearchCriteriaDto;
import by.shag.litvinov.jpa.model.Schedule;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;

public class ScheduleSpecificationUtils {

    public static Specification<Schedule> equalsMovieId(Integer movieId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("movieId"), movieId);
    }

    //Связь с Movie table ???? Женя
    //public static Specification<Schedule> likeMovieName(String movieName) {
    //    return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("movie").get("movieName"), "%" + movieName + "%");
    //}

    public static Specification<Schedule> greaterThanMinStartDateTime(Instant minStartDateTime) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("startDateTime"), minStartDateTime);
    }

    public static Specification<Schedule> lessThanMaxStartDateTime(Instant maxStartDateTime) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("startDateTime"), maxStartDateTime);
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
        //if (criteriaDto.getMovieName() != null) {
        //    specification = specification.and(likeMovieName(criteriaDto.getMovieName()));
        //}
        if (criteriaDto.getMinStartDateTime() != null) {
            specification = specification.and(greaterThanMinStartDateTime(criteriaDto.getMinStartDateTime()));
        }
        if (criteriaDto.getMaxStartDateTime() != null) {
            specification = specification.and(lessThanMaxStartDateTime(criteriaDto.getMaxStartDateTime()));
        }
        if (criteriaDto.getMinEndDateTime() != null) {
            specification = specification.and(greaterThanMinEndDateTime(criteriaDto.getMinEndDateTime()));
        }
        if (criteriaDto.getMaxEndDateTime() != null) {
            specification = specification.and(lessThanMaxEndDateTime(criteriaDto.getMaxEndDateTime()));
        }
        return specification;
    }
}
