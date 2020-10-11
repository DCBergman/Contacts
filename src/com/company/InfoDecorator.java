package com.company;

public class InfoDecorator extends Contact {

    protected Contact contact;
    public InfoDecorator(Contact c) {
        this.contact = c;
    }

    @Override
    public String getName() {
        return this.contact.getName();
    }

    @Override
    public String getPhoneNumber() {
        return this.contact.getPhoneNumber();
    }

    @Override
    public void showInfo() {
        this.contact.showInfo();
    }
}
