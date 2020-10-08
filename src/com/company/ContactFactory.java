package com.company;

public class ContactFactory {

    public enum ContactType {
        FRIEND,
        FAMILY,
        BUSINESS
    }

    public static Contact createContact(ContactType contactType) {
        CreateContactForm cf = new CreateContactForm();
        System.out.println("Please enter contact info \n -------------");
        switch (contactType) {
            case FRIEND:
                return new FriendContact("janina", "0738483838", "Cromwell Road");
            case FAMILY:
                return new FamilyContact("Ebba", "0743858483", "Sister");
            case BUSINESS:
                return new BusinessContact("Anders", "0734829389", "Translator", "Company");
            default:
                Menu.getInstance().showErrorMessage("Could not create contact of type: " + contactType.toString());
                return null;
        }
    }


}
