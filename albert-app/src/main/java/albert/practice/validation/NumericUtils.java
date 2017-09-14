package albert.practice.validation;

import org.apache.commons.validator.routines.IntegerValidator;

import lombok.extern.slf4j.Slf4j;

// https://commons.apache.org/proper/commons-validator/apidocs/org/apache/commons/validator/routines/package-summary.html#package_description
@Slf4j
public class NumericUtils {

	public static void main(String[] args) {
		NumericUtils.isValidNumeric("123");
		log.debug("test=" + NumericUtils.formatNumeric(1235600));
		log.debug("Integer = " + NumericUtils.formatNumberString("1,235,600"));
		NumericUtils.isInValidRange(20, 18, 65);
	}

	/**
	 * 檢查輸入的 number string 是否為數字.
	 * 
	 * @param number
	 */
	public static void isValidNumeric(String number) {
		if (IntegerValidator.getInstance().validate(number) == null) {
			throw new IllegalArgumentException("您輸入的非數字");
		}
	}

	/**
	 * 將 number 加上 1000 separator.
	 * 
	 * @param number
	 * @return
	 */
	public static String formatNumeric(Integer number) {
		return IntegerValidator.getInstance().format(number, "#,##0");
	}

	/**
	 * 將number string 轉成 integer.
	 * 
	 * @param numberStr
	 * @return
	 */
	public static Integer formatNumberString(String numberStr) {
		return IntegerValidator.getInstance().validate(numberStr, "#,##0");
	}

	/**
	 * 檢查數字是否介於指定區間.
	 * 
	 * @param number
	 * @param min
	 * @param max
	 */
	public static void isInValidRange(Integer number, int min, int max) {
		if (!IntegerValidator.getInstance().isInRange(number, min, max)) {
			throw new IllegalArgumentException("您輸入的數字必須介於 " + min + " ~ " + max + " 之間");
		}
	}

}
