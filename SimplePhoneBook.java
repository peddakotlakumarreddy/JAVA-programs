
import java.util.Scanner;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class SimplePhoneBook {
    static Contact[] contacts = new Contact[100]; // max 100 contacts
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Display Contacts (sorted order)");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addContact(sc);
                    break;
                case 2:
                    sortContacts();
                    displayContacts();
                    break;
                case 3:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 3);

        sc.close();
    }

    static void addContact(Scanner sc) {
        if (count >= contacts.length) {
            System.out.println("Phonebook full!");
            return;
        }
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        contacts[count++] = new Contact(name, phone);
        System.out.println("Contact added.");
    }

    static void displayContacts() {
        if (count == 0) {
            System.out.println("No contacts to display.");
            return;
        }
        System.out.println("\nContacts:");
        for (int i = 0; i < count; i++) {
            System.out.println(contacts[i].name + " - " + contacts[i].phone);
        }
    }

    static void sortContacts() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                // Compare ignoring case
                if (contacts[j].name.compareToIgnoreCase(contacts[j + 1].name) > 0) {
                    Contact temp = contacts[j];
                    contacts[j] = contacts[j + 1];
                    contacts[j + 1] = temp;
                }
            }
        }
    }
}
