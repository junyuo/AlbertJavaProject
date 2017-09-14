package albert.practice.designPattern.builder;

import java.io.File;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PlainEmailParam {
	@NotNull(message = "請提供收件者 email")
	private List<String> receiverEmails;
	
	@NotEmpty(message = "主旨不可為空")
	private String subject;
	
	@NotEmpty(message = "內文不可為空")
	private String content;
	
	private List<File> attachments;
}
