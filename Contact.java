package Contact;

public class Contact {

	public String contactId; //No longer than 10 characters, updatable, and not null.
	public String firstName; //No longer than 10 characters, updatable, and not null
	public String lastName; //No longer than 10 characters, updatable, and not null.
	public String phoneNumber; //Exactly 10 digits and not null.
	public String contactDescription; //No longer than 30 characters, not null
	
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String contactDescription) {
		
		if(contactId == null || contactId.trim().length() > 10) {
			throw new IllegalArgumentException("Contact Id must be no longer than ten characters");
		}
		
		if(firstName == null || firstName.trim().length() > 10) {
			throw new IllegalArgumentException("First Name must be no longer than ten characters");
		}
		
		if(lastName == null || lastName.trim().length() > 10) {	
			throw new IllegalArgumentException("Last Name must be no longer than ten characters");
		}
		
		if(phoneNumber == null || phoneNumber.length() != 10) {
			throw new IllegalArgumentException("Phone Number must be exactly ten digits");
		}
		
		if(contactDescription == null || contactDescription.trim().length() > 30) {
			throw new IllegalArgumentException("Contact Description must be no longer than thirty characters");
		}
		
		this.contactId = contactId.trim();
		this.firstName = firstName.trim();
		this.lastName = lastName.trim();
		this.phoneNumber = phoneNumber;
		this.contactDescription = contactDescription.trim();
		
		
	}
	
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getContactDescription() {
		return contactDescription;
	}
	
}
