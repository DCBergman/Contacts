package com.company;

import java.util.Scanner;

public class EditContactMenu {
    private static EditContactMenu instance = null;

    private EditContactMenu() {
    }

    public static EditContactMenu getInstance() {
        if (instance == null) {
            instance = new EditContactMenu();
        }
        return instance;
    }

    public String showMenuAndGetChoice() {

        System.out.println("\nPlease select the information you wish to add:  \n----------");

        String[] infoTypes ={"Address", "Relationship", "Role", "Company"};
        int i = 1;
        for (String contactType: infoTypes) {
            System.out.println(i + ". " + contactType);
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int choiceIndex = scanner.nextInt();
        return infoTypes[choiceIndex-1];

    }
}
