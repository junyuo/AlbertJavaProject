package albert.practice.security;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * https://goo.gl/yWvhzG
 * 
 * @author albert
 *
 */
public class PasswordUtils {

	public static String generateRandomPassword() {
		/*
		 * Constructs a secure random number generator (RNG) implementing the
		 * default random number algorithm.
		 */
		Random secureRandom = new SecureRandom();

		/*
		 * Constructs a randomly generated BigInteger, uniformly distributed
		 * over the range 0 to (2numBits - 1), inclusive. The uniformity of the
		 * distribution assumes that a fair source of random bits is provided in
		 * rnd. Note that this constructor always constructs a non-negative
		 * BigInteger.
		 */
		BigInteger bigInt = new BigInteger(100, secureRandom);

		/*
		 * Returns the String representation of this BigInteger in the given
		 * radix. If the radix is outside the range from Character.MIN_RADIX to
		 * Character.MAX_RADIX inclusive, it will default to 10 (as is the case
		 * for Integer.toString).
		 */
		return bigInt.toString(Character.MAX_RADIX);
	}

}
