package com.alto.addressBook;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.util.Comparator;


public class ContactFinder {

    private final AddressBook addressBook;

    private final Comparator<Contact> OLDEST_COMPARATOR = (c1, c2) -> (c1.getDob().compareTo(c2.getDob()));

    public ContactFinder(AddressBook addressBook) {
        this.addressBook = addressBook;
        this.addressBook.loadAll();
    }

    public long countFemales() {

        return addressBook.getAllContacts()
                .stream()
                .filter(x -> x.getGender().equals(Contact.Gender.Female))
                .count();
    }

    public Contact findOldestPerson() {

        return addressBook.getAllContacts()
                .stream()
                .min(OLDEST_COMPARATOR)
                .get();

    }

    public int compareAgesOfTwoContacts(String firstName1, String firstName2) throws ContactNotFoundException{

        Contact contact1 = addressBook.getContactByFirstName(firstName1);
        Contact contact2 = addressBook.getContactByFirstName(firstName2);

        Period difference = new Period(contact1.getDob(),contact2.getDob(), PeriodType.days());

        return difference.getDays();

    }
}
