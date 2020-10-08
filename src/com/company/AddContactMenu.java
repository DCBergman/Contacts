package com.company;

import java.util.Scanner;

public class AddContactMenu {
    private static AddContactMenu instance = null;

    private AddContactMenu() {
    }

    public static AddContactMenu getInstance() {
        if (instance == null) {
            instance = new AddContactMenu();
        }
        return instance;
    }

    public String showMenuAndGetChoice() {

        System.out.println("\nPlease select type of contact:  \n----------");

        String[] contactTypes ={"Friend", "Family", "Business"};
        int i = 1;
        for (String contactType: contactTypes) {
            System.out.println(i + ". " + contactType);
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int choiceIndex = scanner.nextInt();
        return contactTypes[choiceIndex-1];

    }
}
