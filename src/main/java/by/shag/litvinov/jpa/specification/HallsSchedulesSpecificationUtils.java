package by.shag.litvinov.jpa.specification;

import by.shag.litvinov.api.dto.HallsSchedulesSearchCriteriaDto;
import by.shag.litvinov.jpa.model.HallsSchedules;
import org.springframework.data.jpa.domain.Specification;

public class HallsSchedulesSpecificationUtils {

    public static Specification<HallsSchedules> equalsHallId(Integer hallId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("hallId"), hallId);
    }

    public static Specification<HallsSchedules> equalsScheduleId(Integer scheduleId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("scheduleId"), scheduleId);
    }

    public static Specification<HallsSchedules> defaultSpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("id"), 0);
    }

    public static Specification<HallsSchedules> findBySearchCriteria(HallsSchedulesSearchCriteriaDto criteriaDto) {
        Specification<HallsSchedules> specification = defaultSpecification();
        if (criteriaDto == null) {
            return specification;
        }
        if (criteriaDto.getHallId() != null) {
            specification = specification.and(equalsHallId(criteriaDto.getHallId()));
        }
        if (criteriaDto.getScheduleId() != null) {
            specification = specification.and(equalsScheduleId(criteriaDto.getScheduleId()));
        }
        return specification;
    }
}
