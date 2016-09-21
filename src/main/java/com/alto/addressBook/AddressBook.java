package com.alto.addressBook;

import java.util.*;

public class AddressBook {

    private final Scanner scanner;

    private Map<String,Contact> contacts = new HashMap<String,Contact>();

    public AddressBook(Scanner scanner) {
        this.scanner = scanner;
    }

    public void loadAll() {
        while (scanner.hasNext()) {
                Contact contact = new ContactBuilder()
                        .fromLine(scanner.nextLine())
                        .build();
                contacts.put(contact.getFirstName(), contact);
        }

    }

    public Collection<Contact> getAllContacts() {
        return contacts.values();
    }

    public Contact getContactByFirstName(String firstName) throws ContactNotFoundException{
        if (contacts.containsKey(firstName)) {
            return contacts.get(firstName);
        }
        throw new ContactNotFoundException("Contact " + firstName + " not found");
    }
}
