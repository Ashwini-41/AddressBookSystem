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
			System.out.println("3. Exit ");
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
				System.out.println("Exiting....");
				return;
				
			default:
				System.out.println("Invalid choice. Please try again. ");
				
			}
			
		}
		
	
	}
}
