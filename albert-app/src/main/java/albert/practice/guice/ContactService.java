package albert.practice.guice;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class ContactService {

	public List<Contact> getContacts(String id) {
		log.debug("person id is " + id);
		return ImmutableList.of(new Contact("Mandy", "0912111111"), new Contact("Dad", "0911111111"),
				new Contact("Mom", "0922222222"));
	}

}
