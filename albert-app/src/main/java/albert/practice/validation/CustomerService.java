package albert.practice.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.inject.Singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class CustomerService {

	public void create(Customer customer) {
		validate(customer);
	}

	public static void validate(Object obj) {
		List<String> errors = new ArrayList<>();

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Object>> violations = validator.validate(obj);
		for (ConstraintViolation<Object> violation : violations) {
			errors.add(violation.getMessage());
		}

		String completeErrorMsg = Joiner.on("\n").join(errors);
		if (!Strings.isNullOrEmpty(completeErrorMsg)) {
			throw new IllegalArgumentException(completeErrorMsg);
		}
	}

}
