package com.alto.addressBook;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

import static org.junit.Assert.*;

public class AddressBookTest {

    private static Contact BILL = new Contact("Bill", "McKnight", Contact.Gender.Male, new LocalDate(1977, 03, 16));

    private AddressBook fullAddressBook;

    @Before
    public void setUp() {

        InputStream input = this.getClass().getResourceAsStream("/AddressBook");
        Scanner scanner = new Scanner(input);
        fullAddressBook = new AddressBook(scanner);
        fullAddressBook.loadAll();
    }


    @Test
    public void testLoadAllFromSingleLine() throws Exception {

        String line = "Bill McKnight, Male, 16/03/77";

        Scanner scanner = new Scanner(line);

        AddressBook addressBook = new AddressBook(scanner);

        addressBook.loadAll();

        Collection<Contact> actual = addressBook.getAllContacts();

        assertEquals(1,actual.size());

        assertEquals(BILL,actual.stream().findFirst().get());

    }

    @Test
    public void testNoLoadAllFromDoubleLinesOneDodgy() throws Exception {

        String line = "Bill McKnight, Male, 16/03/77\n dsafdsafdasf";

        Scanner scanner = new Scanner(line);

        AddressBook addressBook = new AddressBook(scanner);

        boolean exceptionThrown = false;

        try {
            addressBook.loadAll();
        }
       catch (IllegalArgumentException ex) {
           exceptionThrown = true;
        }

        assertTrue(exceptionThrown);

    }

    @Test
    public void testLoadAllFromResource() throws Exception {

        Collection<Contact> actual =  fullAddressBook.getAllContacts();
        assertEquals(5,actual.size());

    }

    @Test
    public void testFindKnownContact() throws Exception {

        Contact possibleFind = fullAddressBook.getContactByFirstName("Bill");

        assertEquals(BILL,possibleFind);
    }

    @Test
    public void testNotFindUnkownContact() throws Exception {

        boolean exceptionThrown = false;

        try {
            Contact possibleFind = fullAddressBook.getContactByFirstName("Daniel");
        }
        catch (ContactNotFoundException e) {
            exceptionThrown = true;
            assertEquals("Contact Daniel not found", e.getMessage());
        }

        assertTrue(exceptionThrown);
    }
}