package com.company;

import java.io.Serializable;

public abstract class Contact implements Serializable{

    public abstract String getName();
    public abstract String getPhoneNumber();
    public abstract void showInfo();

}
