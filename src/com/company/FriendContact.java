package com.company;

public class FriendContact extends Contact{
    private String name;
    private String phoneNumber;
    private String address;
    public FriendContact(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
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
        System.out.println("\n" + name + "\n" + phoneNumber + "\n" + address );
    }
}
