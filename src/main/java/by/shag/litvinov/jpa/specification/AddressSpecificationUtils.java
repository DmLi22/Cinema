package by.shag.litvinov.jpa.specification;

import by.shag.litvinov.api.dto.AddressSearchCriteriaDto;
import by.shag.litvinov.jpa.model.Address;
import org.springframework.data.jpa.domain.Specification;

public class AddressSpecificationUtils {

    public static Specification<Address> likeCountry(String country) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("country"), "%" + country + "%");
    }

    public static Specification<Address> likeCity(String city) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("city"), "%" + city + "%");
    }

    public static Specification<Address> likeStreet(String street) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("street"), "%" + street + "%");
    }

    public static Specification<Address> equalsHouseNumber(Integer houseNumber) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("houseNumber"), houseNumber);
    }

    public static Specification<Address> defaultSpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("id"), 0);
    }

    public static Specification<Address> findBySearchCriteria(AddressSearchCriteriaDto criteriaDto) {
        Specification<Address> specification = defaultSpecification();
        if (criteriaDto == null) {
            return specification;
        }
        if (criteriaDto.getCountry() != null) {
            specification = specification.and(likeCountry(criteriaDto.getCountry()));
        }
        if (criteriaDto.getCity() != null) {
            specification = specification.and(likeCity(criteriaDto.getCity()));
        }
        if (criteriaDto.getStreet() != null) {
            specification = specification.and(likeStreet(criteriaDto.getStreet()));
        }
        if (criteriaDto.getHouseNumber() != null) {
            specification = specification.and(equalsHouseNumber(criteriaDto.getHouseNumber()));
        }
        return specification;
    }
}
