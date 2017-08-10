package albert.practice.guice;

import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Inject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonResource {
	
	private ContactService contactService;
	
	@Inject
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	
	public List<Contact> getContacts(String id) {
		return contactService.getContacts(id);
	}
	
	public static void main(String[] args) {
		PersonResource person = Guice.createInjector().getInstance(PersonResource.class);
		log.debug(person.getContacts("12345").toString());
	}
	
}
