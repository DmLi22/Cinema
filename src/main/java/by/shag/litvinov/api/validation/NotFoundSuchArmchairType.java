package by.shag.litvinov.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotFoundSuchArmchairTypeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotFoundSuchArmchairType {

    String message() default "Armchair type with this ID does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
