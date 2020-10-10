package com.company;

import java.io.Serializable;

public class AddressDecorator extends InfoDecorator {
    private String address;
    public AddressDecorator(Contact c, String address) {
        super(c);
        this.address = address;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(address);
    }
}
