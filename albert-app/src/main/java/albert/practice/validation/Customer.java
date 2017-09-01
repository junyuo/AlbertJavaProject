package albert.practice.validation;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Customer {
	public static enum Gender {
		MALE, FEMALE;
	}

	@NotNull(message = "顧客編號不可為 null")
	private Long id;

	@NotEmpty(message = "姓名不可為空")
	private String name;

	@NotNull(message = "性別不可為空")
	private Gender gender;

	@Range(min = 18, max = 60, message = "年齡必須介於 18 到 60 歲之間")
	private Integer age;

	@NotEmpty(message = "Email 不可為空")
	@Email(message = "Email 格式不合法")
	private String email;
	
	@Past(message = "生日必須要今天以前")
	private Date dateOfBirth;
}
