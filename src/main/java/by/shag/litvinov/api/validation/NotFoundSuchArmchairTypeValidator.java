package by.shag.litvinov.api.validation;

import by.shag.litvinov.jpa.model.ArmchairType;
import by.shag.litvinov.jpa.repository.ArmchairTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class NotFoundSuchArmchairTypeValidator implements ConstraintValidator<NotFoundSuchArmchairType, Integer> {

    @Autowired
    private ArmchairTypeRepository repository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        if (id == null) {
            return false;
        }
        Optional<ArmchairType> model = repository.findById(id);
        return model.isPresent();
    }
}
