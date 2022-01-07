package by.shag.litvinov.api.validation;

import by.shag.litvinov.jpa.model.Cinema;
import by.shag.litvinov.jpa.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class NotFoundSuchCinemaValidator implements ConstraintValidator<NotFoundSuchCinema, Integer> {

    @Autowired
    private CinemaRepository repository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        if (id == null) {
            return false;
        }
        Optional<Cinema> model = repository.findById(id);
        return model.isPresent();
    }
}
