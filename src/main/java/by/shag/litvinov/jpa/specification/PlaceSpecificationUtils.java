package by.shag.litvinov.jpa.specification;

import by.shag.litvinov.api.dto.PlaceSearchCriteriaDto;
import by.shag.litvinov.jpa.model.ArmchairTypeEnum;
import by.shag.litvinov.jpa.model.Place;
import org.springframework.data.jpa.domain.Specification;

public class PlaceSpecificationUtils {

    public static Specification<Place> equalsHallId(Integer hallId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("hallId"), hallId);
    }

    public static Specification<Place> equalsArmchairTypeId(Integer armchairTypeId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("armchairTypeId"), armchairTypeId);
    }

    public static Specification<Place> likeArmchairType(ArmchairTypeEnum armchairType) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("armchairType").get("armchairType"), "%" + armchairType + "%");
    }

    public static Specification<Place> greaterThanMinRow(Integer minRow) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("row"), minRow);
    }

    public static Specification<Place> lessThanMaxRow(Integer maxRow) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("row"), maxRow);
    }

    public static Specification<Place> greaterThanMinPlace(Integer minPlace) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("place"), minPlace);
    }

    public static Specification<Place> lessThanMaxPlace(Integer maxPlace) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("place"), maxPlace);
    }

    public static Specification<Place> defaultSpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("id"), 0);
    }

    public static Specification<Place> findBySearchCriteria(PlaceSearchCriteriaDto criteriaDto) {
        Specification<Place> specification = defaultSpecification();
        if (criteriaDto == null) {
            return specification;
        }
        if (criteriaDto.getHallId() != null) {
            specification = specification.and(equalsHallId(criteriaDto.getHallId()));
        }
        if (criteriaDto.getArmchairTypeId() != null) {
            specification = specification.and(equalsArmchairTypeId(criteriaDto.getArmchairTypeId()));
        }
        if (criteriaDto.getArmchairType() != null) {
            specification = specification.and(likeArmchairType(criteriaDto.getArmchairType()));
        }
        if (criteriaDto.getMinRow() != null) {
            specification = specification.and(greaterThanMinRow(criteriaDto.getMinRow()));
        }
        if (criteriaDto.getMaxRow() != null) {
            specification = specification.and(lessThanMaxRow(criteriaDto.getMaxRow()));
        }
        if (criteriaDto.getMinPlace() != null) {
            specification = specification.and(greaterThanMinPlace(criteriaDto.getMinPlace()));
        }
        if (criteriaDto.getMaxPlace() != null) {
            specification = specification.and(lessThanMaxPlace(criteriaDto.getMaxPlace()));
        }
        return specification;
    }
}
