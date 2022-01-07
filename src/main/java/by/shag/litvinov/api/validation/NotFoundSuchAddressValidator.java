package by.shag.litvinov.api.validation;

import by.shag.litvinov.jpa.model.Address;
import by.shag.litvinov.jpa.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class NotFoundSuchAddressValidator implements ConstraintValidator<NotFoundSuchAddress, Integer> {

    @Autowired
    private AddressRepository repository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        if (id == null) {
            return false;
        }
        Optional<Address> model = repository.findById(id);
        return model.isPresent();
    }
}
