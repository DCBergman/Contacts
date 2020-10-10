package com.company;

import java.io.Serializable;

public class RelationshipDecorator extends InfoDecorator {
    private String relationship;
    public RelationshipDecorator(Contact c, String relationship) {
        super(c);
        this.relationship = relationship;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(relationship);
    }
}
