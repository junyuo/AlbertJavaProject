package albert.practice.validation;

import org.apache.commons.validator.routines.DoubleValidator;
import org.apache.commons.validator.routines.IntegerValidator;

public class NumericUtils {

	/**
	 * 檢查輸入的 integer string 是否為數字.
	 * 
	 * @param number
	 */
	public static void isValidInteger(String number) {
		if (IntegerValidator.getInstance().validate(number) == null) {
			throw new IllegalArgumentException("您輸入的非數字");
		}
	}

	/**
	 * 檢查輸入的 double string 是否為數字.
	 * 
	 * @param number
	 */
	public static void isValidDouble(String number) {
		if (DoubleValidator.getInstance().validate(number) == null) {
			throw new IllegalArgumentException("您輸入的非數字");
		}
	}

	/**
	 * 將 integer 加上 1000 separator.
	 * 
	 * @param number
	 * @return
	 */
	public static String formatInteger(Integer number) {
		return IntegerValidator.getInstance().format(number, "#,##0");
	}

	/**
	 * 將 Double 加上 1000 separator.
	 * 
	 * @param number
	 * @return
	 */
	public static String formatDouble(Double number) {
		return DoubleValidator.getInstance().format(number, "#,##0.00");
	}

	/**
	 * 將integer string 轉成 Integer.
	 * 
	 * @param numberStr
	 * @return
	 */
	public static Integer formatIntegerString(String numberStr) {
		return IntegerValidator.getInstance().validate(numberStr, "#,##0");
	}

	/**
	 * 將double string 轉成 Double.
	 * 
	 * @param numberStr
	 * @return
	 */
	public static Double formatDoubleString(String numberStr) {
		return DoubleValidator.getInstance().validate(numberStr, "#,##0.00");
	}

	/**
	 * 檢查 integer 是否介於指定區間.
	 * 
	 * @param number
	 * @param min
	 * @param max
	 */
	public static void isIntegerInValidRange(Integer number, int min, int max) {
		if (!IntegerValidator.getInstance().isInRange(number, min, max)) {
			throw new IllegalArgumentException("您輸入的數字必須介於 " + min + " ~ " + max + " 之間");
		}
	}

	/**
	 * 檢查 double 是否介於指定區間.
	 * 
	 * @param number
	 * @param min
	 * @param max
	 */
	public static void isDoubleInValidRange(Double number, double min, double max) {
		if (!DoubleValidator.getInstance().isInRange(number, min, max)) {
			throw new IllegalArgumentException("您輸入的數字必須介於 " + min + " ~ " + max + " 之間");
		}
	}

}
