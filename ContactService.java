package ContactService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


import Contact.Contact;
//add contacts with unique ID.
//delete contacts per contact ID.
//update contact fields per contact ID.
//following are updatable: firstName, lastName, phone, address.
public class ContactService {
	public static ContactService INSTANCE;
	public Map<String, Contact> repository;
	
	private ContactService() {
			repository = new ConcurrentHashMap<>();
}
	
	public static synchronized ContactService getInstance() {
			if(INSTANCE == null) {
					INSTANCE = new ContactService();
			}
			return INSTANCE;
	}
	
	//Add a new Contact Id
	public void add(final Contact contact) {
			if(repository.containsKey(contact.getContactId())) {
					throw new IllegalArgumentException(String.format("A contact with the ID [%s] already exists"));
			}
			repository.put(contact.getContactId(), contact);
	}
	
	//Delete an existing Task ID.
	public void delete(final String id) {
			if(!repository.containsKey(id)) {
			    throw new IllegalArgumentException(String.format("Delete Task Id"));
			}
			repository.remove(id);
	}
}

