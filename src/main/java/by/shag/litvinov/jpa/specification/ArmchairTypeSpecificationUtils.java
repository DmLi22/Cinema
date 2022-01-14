package by.shag.litvinov.jpa.specification;

import by.shag.litvinov.api.dto.ArmchairTypeSearchCriteriaDto;
import by.shag.litvinov.jpa.model.ArmchairType;
import org.springframework.data.jpa.domain.Specification;

public class ArmchairTypeSpecificationUtils {

    public static Specification<ArmchairType> likeArmchairType(String armchairType) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("armchairType"), "%" + armchairType + "%");
    }

    public static Specification<ArmchairType> likeDescription(String description) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("description"), "%" + description + "%"));
    }

    public static Specification<ArmchairType> defaultSpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("id"), 0);
    }

    public static Specification<ArmchairType> findBySearchCriteria(ArmchairTypeSearchCriteriaDto criteriaDto) {
        Specification<ArmchairType> specification = defaultSpecification();
        if (criteriaDto == null) {
            return specification;
        }
        if (criteriaDto.getArmchairType() != null) {
            specification = specification.and(likeArmchairType(criteriaDto.getArmchairType()));
        }
        if (criteriaDto.getDescription() != null) {
            specification = specification.and((likeArmchairType(criteriaDto.getArmchairType())));
        }
        return specification;
    }
}
