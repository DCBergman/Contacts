package com.company;

import java.util.Scanner;

public class Menu {

    private static Menu instance = null;

    private Menu() {
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public enum MenuItem {
        ADD_CONTACT("Add new contact"),
        VIEW_CONTACTS("View your contacts"),
        VIEW_CONTACTS_BY_CAT("View contacts by category"),
        FIND_CONTACT("Find a contact"),
        REMOVE_CONTACT("Remove a contact"),
        QUIT("Quit the program");

        private String description;

        MenuItem(String description) {
            this.description = description;

        }
    }

    public void showErrorMessage(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    public MenuItem showMenuAndGetChoice() {
        System.out.println("\nMy Contacts \n----------");
        int i = 1;
        for (MenuItem menuItem : MenuItem.values()) {
            System.out.println(i + ". " + menuItem.description);
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int choiceIndex = scanner.nextInt();
        return MenuItem.values()[choiceIndex - 1];

    }

}
