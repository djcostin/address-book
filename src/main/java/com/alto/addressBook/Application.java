package com.alto.addressBook;

import java.io.InputStream;
import java.util.Scanner;

public class Application {

    public static void main(String args[]) {

        InputStream input = Application.class.getResourceAsStream("/AddressBook");
        Scanner scanner = new Scanner(input);
        AddressBook addressBook = new AddressBook(scanner);
        AskQuestions askQuestions = new AskQuestions(new ContactFinder(addressBook))
                .question1()
                .question2()
                .question3("Bill","Paul");

    }
}
