package by.shag.litvinov.jpa.specification;

import by.shag.litvinov.api.dto.HallSearchCriteriaDto;
import by.shag.litvinov.jpa.model.Hall;
import org.springframework.data.jpa.domain.Specification;

public class HallSpecificationUtils {

    public static Specification<Hall> equalsCinemaId(Integer cinemaId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cinemaId"), cinemaId);
    }

    public static Specification<Hall> likeCinemaName(String cinemaName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("cinema").get("name"), "%" + cinemaName + "%");
    }

    public static Specification<Hall> equalsThree3D(Boolean three3D) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("three3D"), three3D);
    }

    public static Specification<Hall> equalsDolbyAtmosSound(Boolean dolbyAtmosSound) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("dolbyAtmosSound"), dolbyAtmosSound);
    }

    public static Specification<Hall> greaterThanMinNumberOfSeats(Integer minNumberOfSeats) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("numberOfSeats"), minNumberOfSeats);
    }

    public static Specification<Hall> lessThanMaxNumberOfSeats(Integer maxNumberOfSeats) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("numberOfSeats"), maxNumberOfSeats);
    }

    public static Specification<Hall> greaterThanMinNumberOfPerson(Integer minNumberOfPerson) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("numberOfPerson"), minNumberOfPerson);
    }

    public static Specification<Hall> lessThanMaxNumberOfPerson(Integer maxNumberOfPerson) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("numberOfPerson"), maxNumberOfPerson);
    }

    public static Specification<Hall> equalsDeluxe(Boolean deluxe) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("deluxe"), deluxe);
    }

    public static Specification<Hall> defaultSpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("id"), 0);
    }

    public static Specification<Hall> findBySearchCriteria(HallSearchCriteriaDto criteriaDto) {
        Specification<Hall> specification = defaultSpecification();
        if (criteriaDto == null) {
            return specification;
        }
        if (criteriaDto.getCinemaId() != null) {
            specification = specification.and(equalsCinemaId(criteriaDto.getCinemaId()));
        }
        if (criteriaDto.getCinemaName() != null) {
            specification = specification.and(likeCinemaName(criteriaDto.getCinemaName()));
        }
        if (criteriaDto.getThree3D() != null) {
            specification = specification.and(equalsThree3D(criteriaDto.getThree3D()));
        }
        if (criteriaDto.getDolbyAtmosSound() != null) {
            specification = specification.and(equalsDolbyAtmosSound(criteriaDto.getDolbyAtmosSound()));
        }
        if (criteriaDto.getMinNumberOfSeats() != null) {
            specification = specification.and(greaterThanMinNumberOfSeats(criteriaDto.getMinNumberOfSeats()));
        }
        if (criteriaDto.getMaxNumberOfSeats() != null) {
            specification = specification.and(lessThanMaxNumberOfSeats(criteriaDto.getMaxNumberOfSeats()));
        }
        if (criteriaDto.getMinNumberOfPerson() != null) {
            specification = specification.and(greaterThanMinNumberOfPerson(criteriaDto.getMinNumberOfPerson()));
        }
        if (criteriaDto.getMaxNumberOfPerson() != null) {
            specification = specification.and(lessThanMaxNumberOfPerson(criteriaDto.getMaxNumberOfPerson()));
        }
        if (criteriaDto.getDeluxe() != null) {
            specification = specification.and(equalsDeluxe(criteriaDto.getDeluxe()));
        }
        return specification;
    }
}
