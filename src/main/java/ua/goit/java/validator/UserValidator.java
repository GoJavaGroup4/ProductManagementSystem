package ua.goit.java.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.goit.java.model.User;
import ua.goit.java.service.UserService;

/**
 * validator for {@link ua.goit.java.model.User} class,
 * implements {@link org.springframework.validation.Validator} interface.
 *
 * @author Semen
 * @version 1.0
 */

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");

		if (userService.findUserByName(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

		if (user.getPassword().length() < 8){
			errors.rejectValue("password", "Size.userForm.password");
		}

		if (!user.getConfirmPassword().equals(user.getPassword())){
			errors.rejectValue("confirmPassword", "Different.userForm.password");
		}
	}
}
