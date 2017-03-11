package albert.practice.security;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordUtilsTest extends PasswordUtils{

	@Test
	public void testGenerateRandomPassword(){
		String randomPassword = generateRandomPassword();
		log.debug("randomPassword = " + randomPassword);
	}
}
