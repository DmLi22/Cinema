package by.shag.litvinov.jpa.specification;

import by.shag.litvinov.api.dto.CinemaSearchCriteriaDto;
import by.shag.litvinov.jpa.model.Cinema;
import org.springframework.data.jpa.domain.Specification;

public class CinemaSpecificationUtils {

    public static Specification<Cinema> likeName(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Cinema> equalsAddressId(Integer addressId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("addressId"), addressId);
    }

    public static Specification<Cinema> likeCountry(String country) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("address").get("country"), "%" + country + "%");
    }

    public static Specification<Cinema> likeCity(String city) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("address").get("city"), "%" + city + "%");
    }

    public static Specification<Cinema> likeStreet(String street) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("address").get("street"), "%" + street + "%");
    }

    public static Specification<Cinema> equalsNumberOfHall(Integer numberOfHall) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("numberOfHall"), numberOfHall);
    }

    public static Specification<Cinema> equalsParking(Boolean parking) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("parking"), parking);
    }

    public static Specification<Cinema> equalsCafe(Boolean cafe) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cafe"), cafe);
    }

    public static Specification<Cinema> defaultSpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("id"), 0);
    }

    public static Specification<Cinema> findBySearchCriteria(CinemaSearchCriteriaDto criteriaDto) {
        Specification<Cinema> specification = defaultSpecification();
        if (criteriaDto == null) {
            return specification;
        }
        if (criteriaDto.getName() != null) {
            specification = specification.and(likeName(criteriaDto.getName()));
        }
        if (criteriaDto.getAddressId() != null) {
            specification = specification.and(equalsAddressId(criteriaDto.getAddressId()));
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
        if (criteriaDto.getNumberOfHall() != null) {
            specification = specification.and(equalsNumberOfHall(criteriaDto.getNumberOfHall()));
        }
        if (criteriaDto.getParking() != null) {
            specification = specification.and(equalsParking(criteriaDto.getParking()));
        }
        if (criteriaDto.getCafe() != null) {
            specification = specification.and(equalsCafe(criteriaDto.getCafe()));
        }
        return specification;
    }
}
