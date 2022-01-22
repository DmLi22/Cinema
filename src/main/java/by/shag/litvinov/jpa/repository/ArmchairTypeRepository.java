package by.shag.litvinov.jpa.repository;

import by.shag.litvinov.jpa.model.ArmchairType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ArmchairTypeRepository extends JpaRepository<ArmchairType, Integer>, JpaSpecificationExecutor<ArmchairType> {

    List<ArmchairType> findByArmchairTypeStartingWithIgnoreCase(String armchairType);

    Optional<ArmchairType> findByArmchairType(String armchairType);
}
