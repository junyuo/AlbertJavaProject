package albert.practice.google.guava;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;

public class GoogleGuavaTest {

	@Test
	public void testJoinStrings() {
		ImmutableSet<String> strings = ImmutableSet.of("Albert", "Mandy", "Graham");
		String joinedString = Joiner.on(",").join(strings);
		assertEquals("Albert,Mandy,Graham", joinedString);

		List<String> fruits = Arrays.asList("apple", null, "orange", null, null, "guava");
		String joinedFruit = Joiner.on(", ").skipNulls().join(fruits);
		assertEquals("apple, orange, guava", joinedFruit);

		String joinedFruit2 = Joiner.on(", ").useForNull("bananna").join(fruits);
		assertEquals("apple, bananna, orange, bananna, bananna, guava", joinedFruit2);
	}

	@Test
	public void testSplitString() {
		String input = ",, ,apple,orange,,,";
		;
		List<String> split = Splitter.on(',').omitEmptyStrings().trimResults().splitToList(input);
		String joinedInput = Joiner.on(", ").join(split);
		assertEquals("apple, orange", joinedInput);
	}

	@Test
	public void testMoreStrings() {
		assertEquals("00123", Strings.padStart("123", 5, '0'));
		assertEquals("", Strings.nullToEmpty(null));
	}

	@Test(expected = NullPointerException.class)
	public void testPreconditionsNPE() {
		Preconditions.checkNotNull(null, "value cannot be null");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPreconditionsCheckArg() {
		Integer speed = 125;
		Preconditions.checkArgument((speed >= 60 && speed <= 120), "速限須介於 60 ~ 120 km 之間，超速超速", speed);
	}
}
