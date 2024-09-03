package absprogram;

import java.util.*;

public class AddressBookSystem {
private List<Contact> contacts = new ArrayList<>();
	
	public void addContacts(Contact contact) {
		contacts.add(contact);
	}
	
	public void printContacts() {
		for(Contact contact: contacts) {
			System.out.println(contact);
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System Program");		
		
		AddressBookSystem addressBook = new AddressBookSystem();
		
		Contact contact = new Contact(
				"Ashwini",
				"Garad",
				"Sadashiv Peth",
				"Pune",
				"Maharastra",
				"414110",
				"87674567890",
				"xyz@gmail.com"
				);
		addressBook.addContacts(contact);
		addressBook.printContacts();
	}
}
