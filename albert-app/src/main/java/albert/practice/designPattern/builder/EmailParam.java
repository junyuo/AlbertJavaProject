package albert.practice.designPattern.builder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.validator.routines.EmailValidator;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;

import lombok.Getter;
import lombok.ToString;

@ToString
public class EmailParam {

	@Getter
	@NotNull(message = "請提供收件者 email")
	private List<String> receiverEmails;

	@Getter
	@NotEmpty(message = "主旨不可為空")
	private String subject; 

	@Getter
	@NotEmpty(message = "內文不可為空")
	private String content; 

	@Getter
	private List<File> attachments; 

	private EmailParam(Builder builder) {
		this.receiverEmails = builder.receiverEmails;
		this.subject = builder.subject;
		this.content = builder.content;
		this.attachments = attachments;
	}

	public static class Builder {

		private List<String> receiverEmails; 
		private String subject;
		private String content;
		private List<File> attachments; 

		public Builder receivers(List<String> receiverEmails) {
			this.receiverEmails = receiverEmails;
			return this;
		}

		public Builder subject(String subject) {
			this.subject = subject;
			return this;
		}

		public Builder content(String content) {
			this.content = content;
			return this;
		}

		public Builder attachments(List<File> attachments) {
			this.attachments = attachments;
			return this;
		}

		public EmailParam build() {
			EmailParam param = new EmailParam(this);
			
			validate(param);
			validateEmails(param);

			return param;
		}

		/**
		 * Do email validation.
		 * 
		 * @param param
		 */
		private void validateEmails(EmailParam param) {
			List<String> receivers = param.getReceiverEmails();
			if (receivers != null && receivers.size() > 0) {
				for (String email : receivers) {
					if (!EmailValidator.getInstance().isValid(email)) {
						throw new IllegalArgumentException("Email 格式有誤");
					}
				}
			}
		}

		/**
		 * Do parameter validation.
		 * 
		 * @param obj
		 */
		public void validate(Object obj) {
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

}
