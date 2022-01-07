package by.shag.litvinov.api.validation;

import by.shag.litvinov.jpa.model.Hall;
import by.shag.litvinov.jpa.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class NotFoundSuchHallValidator implements ConstraintValidator<NotFoundSuchHall, Integer> {

    @Autowired
    private HallRepository repository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        if (id == null) {
            return false;
        }
        Optional<Hall> model = repository.findById(id);
        return model.isPresent();
    }
}
