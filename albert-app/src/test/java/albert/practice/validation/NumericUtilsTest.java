package albert.practice.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NumericUtilsTest {

	private String number;
	private String invalidNumber;

	@Before
	public void setup() {
		number = "12345000";
		invalidNumber = "1000a";
	}

	@Test
	public void testValidNumber() {
		NumericUtils.isValidNumeric(number);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidNumber() {
		NumericUtils.isValidNumeric(invalidNumber);
	}

	@Test
	public void testFormatNumberToString() {
		String numberString = NumericUtils.formatNumeric(12345600);
		assertEquals("12,345,600", numberString);
	}

	@Test
	public void testFormatNumStringToNumber() {
		Integer number = NumericUtils.formatNumberString("12,345,600");
		assertEquals(new Integer(12345600), number);
	}

}
