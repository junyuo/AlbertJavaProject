package albert.practice.validation;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DateUtilsTest {

	private String validDate = "";
	private String invalidDate = "";
	private String startDate = "";
	private String endDate = "";
	private String invalidEndDate = "";

	@Before
	public void setup() {
		validDate = "2017/09/30";
		invalidDate = "2017/09/31";

		startDate = "2017/9/14";
		endDate = "2017/9/15";
		invalidEndDate = "2017/9/11";
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDate() {
		DateUtils.validateDate(invalidDate);
	}

	@Test
	public void testValidDate() {
		DateUtils.validateDate(validDate);
	}

	@Test
	public void testDateConversion() {
		Date date = DateUtils.convertToDate(validDate);
		String dateString = DateUtils.convertToString(date, "yyyy/MM/dd");
		assertEquals("2017/09/30", dateString);
	}

	@Test
	public void testValidStartAndEndDate() {
		DateUtils.compareDays(DateUtils.convertToDate(startDate), DateUtils.convertToDate(endDate));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidStartAndEndDate() {
		DateUtils.compareDays(DateUtils.convertToDate(startDate), DateUtils.convertToDate(invalidEndDate));
	}

}
