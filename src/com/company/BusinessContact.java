package com.company;

import java.io.Serializable;

public class BusinessContact extends Contact{
    private String name;
    private String phoneNumber;
    private String role;
    private String company;
    public BusinessContact(String name, String phoneNumber, String role, String company) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.company = company;
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
        System.out.println("\n" + name + "\n" + phoneNumber + "\n" + role + " at "  + company);

    }
}
