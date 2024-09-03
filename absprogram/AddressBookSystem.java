package absprogram;

import java.util.*;

public class AddressBookSystem {

 private Map<String, AddressBook> addressBooks;
 private static Scanner sc = new Scanner(System.in);
 
 public AddressBookSystem() {
     addressBooks = new HashMap<>();
 }

	public static void main(String[] args) {
        AddressBookSystem system = new AddressBookSystem();
        system.run();
    }
	
	 public void run() {
	        while (true) {
	            System.out.println("1. Add New Address Book");
	            System.out.println("2. Select Address Book");
	            System.out.println("3. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine(); 

	            switch (choice) {
	                case 1:
	                    addNewAddressBook();
	                    break;
	                case 2:
	                    selectAddressBook();
	                    break;
	                case 3:
	                    System.out.println("Exiting...");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	 
	 private void addNewAddressBook() {
	        System.out.print("Enter the name for the new Address Book: ");
	        String name = sc.nextLine();
	        if (addressBooks.containsKey(name)) {
	            System.out.println("An Address Book with this name already exists.");
	        } else {
	            addressBooks.put(name, new AddressBook());
	            System.out.println("Address Book '" + name + "' added successfully.");
	        }
	    }

	 private void selectAddressBook() {
	        System.out.print("Enter the name of the Address Book to select: ");
	        String name = sc.nextLine();
	        AddressBook addressBook = addressBooks.get(name);

	        if (addressBook != null) {
	            manageContacts(addressBook);
	        } else {
	            System.out.println("Address Book not found.");
	        }
	    }
	 
	 private void manageContacts(AddressBook addressBook) {
	        while (true) {
	            System.out.println("1. Add New Contact");
	            System.out.println("2. Display Contacts");
	            System.out.println("3. Edit Contact");
	            System.out.println("4. Delete Contact");
	            System.out.println("5. Back to Main Menu");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine(); 

	            switch (choice) {
	                case 1:
	                    addNewContacts(addressBook);
	                    break;
	                case 2:
	                    addressBook.printContacts();
	                    break;
	                case 3:
	                    editContact(addressBook);
	                    break;
	                case 4:
	                    deleteContact(addressBook);
	                    break;
	                case 5:
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	
	
	
	private static void addNewContacts(AddressBook addressBook) {
		
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
		addressBook.addContact(contact);
		System.out.println("Contact added successfully! ");
		
		System.out.println("Do you want to add another contact? (yes/no): ");
		String response = sc.nextLine();
		
		if(!response.equalsIgnoreCase("yes")) {
			break;
		}
	}
		
		
	}
	

	private static void editContact(AddressBook addressBook) {
		System.out.println("Enter first name to the contact to edit: ");
		String firstName = sc.nextLine();
		System.out.print("Enter Last Name of the contact to edit: ");
        String lastName = sc.nextLine();
        
        if(!addressBook.editContact(firstName, lastName)) {
        	System.out.println("Contact not found. ");
        }

		
	}
	

	private static void deleteContact(AddressBook addressBook) {
		System.out.print("Enter First Name of the contact to delete: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name of the contact to delete: ");
        String lastName = sc.nextLine();
        
        if(!addressBook.deleteContact(firstName, lastName)) {
            System.out.println("Contact not found. Please check the name and try again.");

        }

	}
	
}
