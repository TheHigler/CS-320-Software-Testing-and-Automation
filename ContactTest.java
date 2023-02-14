package ContactTest;

import org.junit.jupiter.api.Test;

import Contact.Contact;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;



public class ContactTest{
	//private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@Test
	void contactTest() {
		Contact contact = new Contact("012345678", "Drizzt", "Do'Urden", "0123456789" ,"This is a description");
		assertTrue(contact.getContactId().equals("012345678"));
		assertTrue(contact.getFirstName().equals("Drizzt"));
		assertTrue(contact.getLastName().equals("Do'Urden"));
		assertTrue(contact.getPhoneNumber().equals("0123456789"));
		assertTrue(contact.getContactDescription().equals("This is a description"));
	}
	
	@Test
	void contactTest_TrimWhitespace() {
		Contact contact = new Contact("     012345678     ", "     Drizzt     ", "     Do'Urden     ", "0123456789" ,"     This is a description     ");
		assertTrue(contact.getContactId().equals("012345678"));
		assertTrue(contact.getFirstName().equals("Drizzt"));
		assertTrue(contact.getLastName().equals("Do'Urden"));
		assertTrue(contact.getContactDescription().equals("This is a description"));
	}
	
	
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("01234567899", "Drizzt", "Do'Urden", "0123456789" ,"This is a description");
		});
	}
	
	@Test
	void testContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Drizzt", "Do'Urden", "0123456789" ,"This is a description");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("012345678", "Drizztttttt", "Do'Urden", "0123456789" ,"This is a description");
		});
	}
	
	@Test
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("012345678", null , "Do'Urden", "0123456789" ,"This is a description");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("012345678", "Drizzt" , "Do'Urdennnn", "01234567899", "This is a description that is more than fifty characters long");
		});
	}
	
	@Test
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("012345678", "Drizzt" , null , "01234567899", "This is a description that is more than fifty characters long");
		});
	}
	
	@Test
	void testPhoneNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("012345678", "Drizzt", "Do'Urden", "01234567899" ,"This is a description");
		});
	}
	
	@Test
	void testPhoneNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("012345678", "Drizzt", "Do'Urden", null ,"This is a description");
		});
	}
	
	
	@Test
	void testAppointmentDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("012345678", "Drizzt", "Do'Urden", "0123456789" ,"This is a description is more than thirty characters long");
		});
	}
	
	@Test
	void testAppointmentDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("012345678", "Drizzt", "Do'Urden", "0123456789" , null);
		});
	}

}
