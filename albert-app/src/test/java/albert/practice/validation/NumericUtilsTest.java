package albert.practice.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NumericUtilsTest {

	private String integerString;
	private String invalidIntegerString;

	private String doubleString;
	private String invaliddoubleString;

	@Before
	public void setup() {
		integerString = "12345000";
		invalidIntegerString = "1000a";

		doubleString = "12400.60";
		invaliddoubleString = "12400a.60";
	}

	@Test
	public void testValidInteger() {
		NumericUtils.isValidInteger(integerString);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidInteger() {
		NumericUtils.isValidInteger(invalidIntegerString);
	}

	@Test
	public void testFormatIntegerToString() {
		String numberString = NumericUtils.formatInteger(12345600);
		assertEquals("12,345,600", numberString);
	}

	@Test
	public void testFormatNumStringToInteger() {
		Integer number = NumericUtils.formatIntegerString("12,345,600");
		assertEquals(new Integer(12345600), number);
	}

	@Test
	public void testIntegerIsInRange() {
		NumericUtils.isIntegerInValidRange(new Integer(22), 20, 30);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIntegerIsNotInRange() {
		NumericUtils.isIntegerInValidRange(new Integer(35), 20, 30);
	}

	@Test
	public void testValidDouble() {
		NumericUtils.isValidDouble(doubleString);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDouble() {
		NumericUtils.isValidDouble(invaliddoubleString);
	}

	@Test
	public void testFormatDouble(){
		String number = NumericUtils.formatDouble(new Double(12300));
		assertEquals("12,300.00", number);
	}
	
	@Test
	public void testFormatStringToDouble() {
		Double number = NumericUtils.formatDoubleString(doubleString);
		assertEquals(new Double(12400.60), number);
	}

	@Test
	public void testDoubleIsInRange() {
		NumericUtils.isDoubleInValidRange(new Double(20.5), 20.0, 30.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDoubleIsNotInRange() {
		NumericUtils.isDoubleInValidRange(new Double(30.5), 20.0, 30.0);
	}

}
