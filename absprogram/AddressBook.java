package absprogram;
import java.util.*;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;

public class AddressBook {
       
	private List<Contact> contacts;
	private Map<String, List<Contact>> cityContactMap;
    private Map<String, List<Contact>> stateContactMap;

    public AddressBook() {
        contacts = new ArrayList<>();
        cityContactMap = new HashMap<>();
        stateContactMap = new HashMap<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        addToCityMap(contact);
        addToStateMap(contact);
    }

    private void addToCityMap(Contact contact) {
    	cityContactMap.computeIfAbsent(contact.getCity(), k -> new ArrayList<>()).add(contact);
    }
    
    private void addToStateMap(Contact contact) {
    	stateContactMap.computeIfAbsent(contact.getState(), k -> new ArrayList<>()).add(contact);
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
		
		
		public Collection<Contact> getContacts(){
			return contacts;
		}
		
		public List<Contact> getContactByCity(String city){
			return cityContactMap.getOrDefault(city, Collections.emptyList());
		}
		
		public List<Contact> getContactsByState(String state) {
	        return stateContactMap.getOrDefault(state, Collections.emptyList());
	    }
		
		public void printContacts() {
	        contacts.forEach(System.out::println);
	    }
	
		
}
