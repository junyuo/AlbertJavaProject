package albert.practice.validation;

import java.util.Date;

import org.apache.commons.validator.routines.DateValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateUtils {

	public static void main(String[] args) {
		DateUtils.validateDate("2017/9/30");
		log.debug(DateUtils.convertToDate("2017/9/30").toString());
		log.debug(DateUtils.convertToString(new Date(), "yyyy/MM/dd"));
		DateUtils.compareDays(DateUtils.convertToDate("2017/9/30"), DateUtils.convertToDate("2017/9/30"));
	}

	/**
	 * 檢查 date string 格式是否符合 yyyy/MM/dd 格式.
	 * 
	 * @param dateString
	 */
	public static void validateDate(String dateString) {
		if (!DateValidator.getInstance().isValid(dateString, "yyyy/MM/dd")) {
			throw new IllegalArgumentException("Valid date format is yyyy/MM/dd");
		}
	}

	/**
	 * 檢查 date string 格式是否符合 yyyy/MM/dd 格式, 若符合則回傳 java.util.Date
	 * 
	 * @param dateString
	 *            ex. 2017/9/14
	 * @return java.util.Date
	 */
	public static Date convertToDate(String dateString) {
		validateDate(dateString);
		return DateValidator.getInstance().validate(dateString, "yyyy/MM/dd");
	}

	/**
	 * 將 Date 轉成指定格式 (ex. yyyy/MM/dd)的 date string.
	 * 
	 * @param date
	 *            java.util.Date
	 * @param pattern
	 *            ex. yyyy/MM/dd
	 * @return date String
	 */
	public static String convertToString(Date date, String pattern) {
		return DateValidator.getInstance().format(date, pattern);
	}

	/**
	 * 時間起迄檢查.
	 * 
	 * @param startDate
	 *            開始日期
	 * @param endDate
	 *            結束日期
	 */
	public static void compareDays(Date startDate, Date endDate) {
		int compare = DateValidator.getInstance().compareDates(startDate, endDate, null);
		if (compare > 0) {
			throw new IllegalArgumentException("結束時間不可早於開始時間");
		}
	}
}
