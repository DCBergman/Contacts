package com.company;

import java.util.Scanner;

public class CreateContactForm {
    Scanner scanner = new Scanner(System.in);

    public String getName(){
        System.out.print("Name: ");
        String name = scanner.nextLine();
        return name;
    }
    public String getPhoneNumber(){
        System.out.print("Phone Number: ");
        String phoneNum = scanner.nextLine();
        return phoneNum;
    }
    public String getAddress(){
        System.out.print("Address: ");
        String address = scanner.nextLine();
        return address;
    }
    public String getRelationship(){
        System.out.print("Relationship: ");
        String relationship = scanner.nextLine();
        return relationship;
    }
    public String getRole(){
        System.out.print("Role: ");
        String role = scanner.nextLine();
        return role;
    }
    public String getCompany(){
        System.out.print("Company: ");
        String company = scanner.nextLine();
        return company;
    }

}
