package by.shag.litvinov.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotFoundSuchScheduleValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotFoundSuchSchedule {

    String message() default "Schedule with this ID does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
