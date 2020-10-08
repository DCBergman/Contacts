package com.company;

public class BusinessContact extends Contact{
    private String role;
    private String company;

    public BusinessContact(String name, String phoneNumber, String role, String company) {
        super(name, phoneNumber);
        this.role = role;
        this.company = company;
    }

    public String getRole() {
        return role;
    }
    public String getCompany() {
        return company;
    }

    public void showInfo(){
        System.out.println("----------\n" + getName()+ "\n"+ "Phone number: " + getPhoneNumber() + "\n" + getRole() + " at " + getCompany());

    }
}
