package com.alto.addressBook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ApplicationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testMain() throws Exception {

        Application.main(null);
        assertEquals("1. There are 2 females in the address book\n" +
                "2. The oldest person is Wes Jackson\n" +
                "3. Bill is 2862 days older than Paul", outContent.toString().trim());
    }

}