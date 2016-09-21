package com.alto.addressBook;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactBuilderTest {

    @Test
    public void testBuildFromLine() throws Exception {

        String line = "Bill McKnight, Male, 16/03/77";

        Contact expected = new Contact("Bill","McKnight", Contact.Gender.Male,new LocalDate(1977,03,16));

        Contact builtOne = new ContactBuilder()
                .fromLine(line)
                .build();

        assertEquals(expected,builtOne);
        assertEquals("Bill",builtOne.getFirstName());
        assertEquals("McKnight",builtOne.getLastName());
        assertEquals(Contact.Gender.Male,builtOne.getGender());
        assertEquals(new LocalDate(1977,03,16),builtOne.getDob());
        assertEquals(expected.hashCode(),builtOne.hashCode());
    }

    @Test
    public void testThrowExceptionIfLineNotCorrect() {
        String line = "";

        boolean exceptionThrown = false;

        try {
            Contact builtOne = new ContactBuilder()
                    .fromLine(line)
                    .build();
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }
}