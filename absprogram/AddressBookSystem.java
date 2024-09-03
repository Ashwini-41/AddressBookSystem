package absprogram;

import java.util.*;

public class AddressBookSystem {
private List<Contact> contacts = new ArrayList<>();

private static AddressBookSystem addressBook = new AddressBookSystem();
static Scanner sc = new Scanner(System.in); 
	
	public void addContacts(Contact contact) {
		contacts.add(contact);
	}
	
	private static void addNewContacts() {
		
	while(true) {
		
		System.out.println("Enter first name: ");
		String firstName = sc.nextLine();
		System.out.println("Enter last name: ");
		String lastName = sc.nextLine();
		System.out.println("Enter Address: ");
		String address = sc.nextLine();
		System.out.println("Enter City name: ");
		String city = sc.nextLine();
		System.out.println("Enter State: ");
		String state = sc.nextLine();
		System.out.println("Enter Zip: ");
		String zip = sc.nextLine();
		System.out.println("Enter Phone number: ");
		String phoneNumber = sc.nextLine();
		System.out.println("Enter Email: ");
		String email = sc.nextLine();
		
		Contact contact = new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
		addressBook.addContacts(contact);
		System.out.println("Contact added successfully! ");
		
		System.out.println("Do you want to add another contact? (yes/no): ");
		String response = sc.nextLine();
		
		if(!response.equalsIgnoreCase("yes")) {
			break;
		}
	}
		
		
	}
	
	//edit
	public boolean editContact(String firstName, String lastName) {
		Optional<Contact> contactOpt = contacts.stream()
				.filter(contact -> contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName))
				.findFirst();
		
		if(contactOpt.isPresent()) {
			Contact contact = contactOpt.get();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Editing contact: " + contact);
			System.out.println("Enter new Address: ");
			contact.setAddress(sc.nextLine());
			System.out.print("Enter new City: ");
	         contact.setCity(sc.nextLine());
	         System.out.print("Enter new State: ");
	         contact.setState(sc.nextLine());
	         System.out.print("Enter new Zip: ");
	         contact.setZip(sc.nextLine());
	         System.out.print("Enter new Phone Number: ");
	         contact.setPhoneNumber(sc.nextLine());
	         System.out.print("Enter new Email: ");
	         contact.setEmail(sc.nextLine());

	         System.out.println("Contact updated successfully.");
			return true;
		}else {
			System.out.println("Contact not found.");
			return false;
		}
	}
	
	private static void editContact() {
		System.out.println("Enter first name to the contact to edit: ");
		String firstName = sc.nextLine();
		System.out.print("Enter Last Name of the contact to edit: ");
        String lastName = sc.nextLine();
        
        if(!addressBook.editContact(firstName, lastName)) {
        	System.out.println("Contact not found. ");
        }

		
	}
	
	//delete contact
	public boolean deleteContact(String firstName, String lastName) {
		Iterator<Contact> iterator = contacts.iterator();
		
		while(iterator.hasNext()) {
			Contact contact = iterator.next();
			if(contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
				iterator.remove();
				System.out.println("Contact deleted successfully!!");
				return true;
			}
		}
		
		System.out.println("Contact not found. ");
		return false;
	}
	
	private static void deleteContact() {
		System.out.print("Enter First Name of the contact to delete: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name of the contact to delete: ");
        String lastName = sc.nextLine();
        
        if(!addressBook.deleteContact(firstName, lastName)) {
            System.out.println("Contact not found. Please check the name and try again.");

        }

	}
	
	public void printContacts() {
		for(Contact contact: contacts) {
			System.out.println(contact);
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System Program");		
		
		while(true) {
			System.out.println("1. Add New Contact");
			System.out.println("2. Display Contact");
			System.out.println("3. Edit Contact");
			System.out.println("4. Delete Contact");
			System.out.println("5. Exit ");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 :
				addNewContacts();
				break;
				
			case 2:
				addressBook.printContacts();
				break;
			case 3:
				editContact();
				break;
			case 4:
				deleteContact();
				break;
			
			case 5:
				System.out.println("Exiting....");
				return;
				
			default:
				System.out.println("Invalid choice. Please try again. ");
				
			}
			
		}
		
	
	}
}
