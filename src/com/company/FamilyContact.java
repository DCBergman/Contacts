package com.company;

public class FamilyContact extends Contact{
    private String relationship;

    public FamilyContact(String name, String phoneNumber, String relationship) {
        super(name, phoneNumber);
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }
    public void showInfo(){
        System.out.println("----------\n" + getName()+ "\n"+ "Phone number: " + getPhoneNumber() + "\n" + "Relation: " + getRelationship());

    }
}
