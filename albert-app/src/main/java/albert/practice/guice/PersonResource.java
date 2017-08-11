package albert.practice.guice;

import java.util.List;

import com.google.inject.Inject;

// https://www.oschina.net/translate/java-ee-cdi-dependency-injection-inject-tutorial
public class PersonResource {
	
	@Inject
	private ContactService contactService;
	
	public List<Contact> getContacts(String id) {
		return contactService.getContacts(id);
	}
	
}
