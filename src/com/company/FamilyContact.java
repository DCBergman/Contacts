package com.company;

import java.io.Serializable;

public class FamilyContact extends Contact {
    private String name;
    private String phoneNumber;
    private String relationship;
    public FamilyContact(String name, String phoneNumber, String relationship) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.relationship= relationship;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void showInfo() {
        System.out.println("\n" + name + "\n" + phoneNumber + "\n" + relationship );
    }
}
