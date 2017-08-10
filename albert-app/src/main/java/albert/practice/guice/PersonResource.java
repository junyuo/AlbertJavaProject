package albert.practice.guice;

import java.util.List;

import com.google.inject.Inject;

public class PersonResource {
	
	private ContactService contactService;
	
	@Inject
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	
	public List<Contact> getContacts(String id) {
		return contactService.getContacts(id);
	}
	
}
