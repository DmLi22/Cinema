package by.shag.litvinov.api.validation;

import by.shag.litvinov.jpa.model.Schedule;
import by.shag.litvinov.jpa.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class NotFoundSuchScheduleValidator implements ConstraintValidator<NotFoundSuchSchedule, Integer> {

    @Autowired
    private ScheduleRepository repository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        if (id == null) {
            return false;
        }
        Optional<Schedule> model = repository.findById(id);
        return model.isPresent();
    }
}
