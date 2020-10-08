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
                return new FriendContact(cf.getName(), cf.getPhoneNumber(), cf.getAddress());
            case FAMILY:
                return new FamilyContact(cf.getName(), cf.getPhoneNumber(), cf.getRelationship());
            case BUSINESS:
                return new BusinessContact(cf.getName(), cf.getPhoneNumber(), cf.getRole(), cf.getCompany());
            default:
                Menu.getInstance().showErrorMessage("Could not create contact of type: " + contactType.toString());
                return null;
        }
    }


}
