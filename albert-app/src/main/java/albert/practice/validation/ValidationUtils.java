package albert.practice.validation;

import java.io.StringReader;
import java.io.StringWriter;

import org.w3c.tidy.Tidy;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationUtils {

	public static ResultBean isHtmlValid(String htmlString) {
		Tidy tidy = new Tidy();

		StringWriter writer = new StringWriter();
		tidy.parse(new StringReader(htmlString), writer);

		int errors = tidy.getParseErrors();
		int warnings = tidy.getParseWarnings();
		String html = writer.toString();

		log.debug("errors = " + errors + ", warnings = " + warnings);
		log.debug("writer = " + writer.toString());

		return new ResultBean.ResultBeanBuilder().htmlStr(html).errors(errors).warnings(warnings).build();
	}

	@Getter
	@Builder
	public static class ResultBean {
		private String htmlStr;
		private int errors;
		private int warnings;
	}

}
