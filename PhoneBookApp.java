import java.util.ArrayList;
import java.util.Scanner;

// Contact class
class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void display() {
        System.out.println("Name: " + name + ", Phone: " + phoneNumber);
    }
}

// PhoneBook class
class PhoneBook {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phoneNumber) {
        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added.");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
        } else {
            System.out.println("Phonebook:");
            for (Contact c : contacts) {
                c.display();
            }
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                c.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String name) {
        boolean removed = contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}

// Main application class
public class PhoneBookApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        int choice;

        do {
            System.out.println("\n--- Phonebook Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String name, phone;

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    phone = scanner.nextLine();
                    phoneBook.addContact(name, phone);
                    break;
                case 2:
                    phoneBook.displayContacts();
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    name = scanner.nextLine();
                    phoneBook.searchContact(name);
                    break;
                case 4:
                    System.out.print("Enter name to delete: ");
                    name = scanner.nextLine();
                    phoneBook.deleteContact(name);
                    break;
                case 5:
                    System.out.println("Exiting phonebook.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
