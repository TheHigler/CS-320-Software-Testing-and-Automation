package ContactServiceTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Contact.Contact;
import ContactService.ContactService;

public class ContactServiceTest {
	private ContactService service;
	
	@BeforeEach
	void init() {
			ContactService.INSTANCE = null;
			service = ContactService.getInstance();
	}
	
	@Test
	void add_Success() {
			final Contact contact = new Contact("1", "Drizzt", "Do'Urden", "0123456789", "This is a description");
			service.add(contact);
			assertTrue(service.repository.containsKey("1"));
	}
	
	@Test
	void add_ExistingId() {
			final Contact contact = new Contact("1", "Drizzt", "Do'Urden", "0123456789", "This is a description");
			service.add(contact);
			assertThrows(IllegalArgumentException.class, () -> service.add(contact));
	}
	@Test
	void delete_Success() {
		final Contact contact = new Contact("2", "Drizzt", "Do'Urden", "0123456789", "This is a description");
			ContactService.INSTANCE.repository.put("2", contact);
			service.delete("2");
			assertFalse(ContactService.INSTANCE.repository.containsKey("2"));
	}
}

