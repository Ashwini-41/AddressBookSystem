package absprogram;

import java.util.*;
import java.util.stream.Collectors;

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
	            System.out.println("3. Search Contacts by City/State");
	            System.out.println("4.View Contacts by City/State");
	            System.out.println("5.Count contacts by City/State");
	            System.out.println("6. Exit");
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
	                	searchContactsByCityOrState();
	                    break;
	                case 4:
	                	viewContactsByCityOrState();
	                	break;
	                case 5: 
	                	countContactsByCityOrState();
	                    break;
	                case 6:
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
	            //System.out.println("5. Count Contacts by city or state");
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
	private void searchContactsByCityOrState() {
        System.out.print("Enter City or State to search: ");
        String location = sc.nextLine();

        List<Contact> result = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContacts().stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(location) || contact.getState().equalsIgnoreCase(location))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No contacts found in the given city/state.");
        } else {
            result.forEach(System.out::println);
        }
    }
	
	//view person 
	private void viewContactsByCityOrState() {
        System.out.println("1. View Contacts by City");
        System.out.println("2. View Contacts by State");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                viewContactsByCity();
                break;
            case 2:
                viewContactsByState();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
	
	//view contact by city
	private void viewContactsByCity() {
        System.out.print("Enter City to view contacts: ");
        String city = sc.nextLine();

        List<Contact> result = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContactByCity(city).stream())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No contacts found in the city.");
        } else {
            result.forEach(System.out::println);
        }
    }
	
	//view contact by state
	private void viewContactsByState() {
        System.out.print("Enter State to view contacts: ");
        String state = sc.nextLine();

        List<Contact> result = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContactsByState(state).stream())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No contacts found in the state.");
        } else {
            result.forEach(System.out::println);
        }
    }
	
	//count of contact 
	private void countContactsByCityOrState() {
		System.out.println("1. Count contacts by city ");
		System.out.println("2. Count contacts by state ");
		System.out.println("Enter your choice");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			countContactsByCity();
			break;
		case 2:
			countContactsByState();
			break;
		default:
			System.out.println("Invalid choice. Please try again. ");
			
		}
	}
	

	private void countContactsByCity() {
        System.out.print("Enter City to count contacts: ");
        sc.next();
        String city = sc.nextLine();

        long countCity = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContactByCity(city).stream())
                .count();

        System.out.println("Number of contacts in city '" + city + " : " + countCity);
    }

    private void countContactsByState() {
        System.out.print("Enter State to count contacts: ");
        sc.next();
        String state = sc.nextLine();

        long count = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContactsByState(state).stream())
                .count();

        System.out.println("Number of contacts in state '" + state + " : " + count);
    }
	
	
	
}
