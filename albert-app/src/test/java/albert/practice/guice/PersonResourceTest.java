package albert.practice.guice;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonResourceTest {
	
	private PersonResource personResouce;
	
	@Before
	public void setup() {
		personResouce = Guice.createInjector().getInstance(PersonResource.class);
	}
	
	@Test
	public void testGetContacts() {
		List<Contact> contacts = personResouce.getContacts("123");
		contacts.stream().forEach(c -> log.debug(c.toString()));
		
		assertEquals(3, contacts.size());
	}
}
