package com.alto.addressBook;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ContactFinderTest {

    private ContactFinder contactFinder;

    @Before
    public void setUp() {

        InputStream input = this.getClass().getResourceAsStream("/AddressBook");
        Scanner scanner = new Scanner(input);
        AddressBook addressBook = new AddressBook(scanner);
        contactFinder = new ContactFinder(addressBook);
    }

    @Test
    public void testCountFemales() throws Exception {

        assertEquals(2, contactFinder.countFemales());
    }

    @Test
    public void testFindOldestPerson() throws Exception {

        assertEquals("Wes",contactFinder.findOldestPerson().getFirstName());
    }

    @Test
    public void testFindDifferenceInAgesFor2KnownContacts() throws Exception {

        int daysOlder = contactFinder.compareAgesOfTwoContacts("Bill","Paul");

        assertEquals("Bill Older Than Paul", 2862,daysOlder);
    }
}