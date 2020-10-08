package com.company;

public class FriendContact extends Contact {

    private String address;
    public FriendContact(String name, String phoneNumber, String address) {
        super(name, phoneNumber);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public void showInfo(){
        System.out.println("----------\n" + getName()+ "\n"+ "Phone number: " + getPhoneNumber() + "\n" + "Address: " + getAddress());

    }
}
