package org.questions.ctlr;

import org.questions.domain.AppUser;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * mdnhuda@gmail.com
 * Date: Jun 30, 2010
 */
public class AppUserValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return AppUser.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "required", "Required!");
        ValidationUtils.rejectIfEmpty(errors, "userId", "required", "Required!");
        ValidationUtils.rejectIfEmpty(errors, "password", "required", "Required!");
    }
}
