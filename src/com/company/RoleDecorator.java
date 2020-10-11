package com.company;

public class RoleDecorator extends InfoDecorator {
    private String role;
    public RoleDecorator(Contact c, String role) {
        super(c);
        this.role = role;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(role);
    }
}
