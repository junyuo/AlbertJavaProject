package albert.practice.designPattern.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailParamTest {
	
	@Test
	public void testPlainEmailParam() {
		PlainEmailParam param = new PlainEmailParam();
		param.setReceiverEmails(Arrays.asList("test1@test.com", "test2@test.com"));
		param.setSubject("test");
		param.setContent("just for testing");
		
		validate(param);
		validateEmails(param);
		
		log.debug(param.toString());
	}
	
	@Test
	public void testEmailParam() {
		List<String> receivers = Arrays.asList("test1@test.com", "test2@test.com");
		EmailParam param
			= new EmailParam.Builder().receivers(receivers).subject("test").content("just for testing")
				.build();
		log.debug(param.toString());
	}
	
	private void validateEmails(PlainEmailParam param) {
		List<String> receivers = param.getReceiverEmails();
		if (receivers != null && receivers.size() > 0) {
			for (String email : receivers) {
				if (!EmailValidator.getInstance().isValid(email)) {
					throw new IllegalArgumentException("Email 格式有誤");
				}
			}
		}
	}

	private void validate(Object obj) {
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
