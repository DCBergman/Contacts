package com.company;

import java.io.Serializable;

public class CompanyDecorator extends InfoDecorator{
    private String company;
    public CompanyDecorator(Contact c, String company) {
        super(c);
        this.company = company;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(company);
    }
}
