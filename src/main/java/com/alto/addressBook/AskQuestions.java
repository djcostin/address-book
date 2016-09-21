package com.alto.addressBook;

public class AskQuestions {

    private final ContactFinder contactFinder;

    public AskQuestions(ContactFinder contactFinder) {
        this.contactFinder = contactFinder;
    }

    public AskQuestions question1() {

        long number = contactFinder.countFemales();
        System.out.println("1. There are " + number + " females in the address book");
        return this;
    }

    public AskQuestions question2() {
        Contact contact = contactFinder.findOldestPerson();
        System.out.println("2. The oldest person is " + contact.getFirstName() + " " + contact.getLastName());
        return this;
    }

    public AskQuestions question3(String contact1, String contact2){

        try {
            long ageDifference = contactFinder.compareAgesOfTwoContacts(contact1,contact2);
            System.out.println("3. " + contact1 + " is " +ageDifference + " days older than "+ contact2);
        } catch (ContactNotFoundException e) {
            System.out.println("Error finding one of the contacts " + e.getMessage());
        }

        return this;
    }
}
