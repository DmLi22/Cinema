package by.shag.litvinov.jpa.repository;

import by.shag.litvinov.jpa.model.ArmchairType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArmchairTypeRepository extends JpaRepository<ArmchairType, Integer>, JpaSpecificationExecutor<ArmchairType> {
}
