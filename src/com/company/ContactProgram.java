package com.company;

import java.beans.Customizer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactProgram {

    private Menu menu = Menu.getInstance();
    private ArrayList<Contact> contacts = new ArrayList<>();

    public ContactProgram(){

    }

    public void start() {

        addExistingContacts();
        Menu.MenuItem choice;
        do {
            choice = Menu.getInstance().showMenuAndGetChoice();
            try {
                switch (choice) {
                    case ADD_CONTACT:
                        String contactType = AddContactMenu.getInstance().showMenuAndGetChoice();
                        if(contactType == "Friend"){
                            addContact(ContactFactory.ContactType.FRIEND);
                        } else if (contactType == "Family") {
                            addContact(ContactFactory.ContactType.FAMILY);
                        }else if( contactType == "Business"){
                            addContact(ContactFactory.ContactType.BUSINESS);
                        }else{
                            System.out.println("Invalid input, try again.");
                        }
                        break;
                    case VIEW_CONTACTS:
                        for (Contact c : contacts ) {
                            c.showInfo();
                        }
                        break;
                    case VIEW_CONTACTS_BY_CAT:
                        //    System.out.println("-------------\n");
                        //   for (Customer c : customers) {
                        //       System.out.println(c.getName() + " is attending " + c.getClassAttending());
                        //   }
                        //   input = new Scanner(System.in);
                        System.out.println("\nPress Enter to continue");
                        //  input.nextLine();
                        break;
                    case FIND_CONTACT:
                        break;
                    case REMOVE_CONTACT:

                        break;
                    case QUIT:
                        FileUtility.saveObject("src/files/contacts.ser", contacts);
                        break;
                    default:
                        menu.showErrorMessage("Menu item not found.");

                }
            }catch (Exception e){
                System.out.println("Invalid input");
            }

        } while (choice != Menu.MenuItem.QUIT);

    }
    public static List<Contact> readObjects(String fileName) {
        ObjectInputStream objectinputstream = null;
        List<Contact> contactsList = null;
        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            contactsList= (List<Contact>) objectinputstream.readObject();
            objectinputstream.close();
        } catch (FileNotFoundException e){
            System.out.println("File does not exist in filepath");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        contactsList.get(0).getName();
        return contactsList;
    }

    public void addExistingContacts() {
        String fileName = "src/files/contacts.ser";
        try{
            for (Contact c : readObjects(fileName)) {
                contacts.add(c);
            }
        }catch(NullPointerException e){
            System.out.println( "File does not exist" );
        }

    }

    public void addContact(ContactFactory.ContactType contactType) {
        Contact contact = ContactFactory.createContact(contactType);
        if (contact != null) {
            contacts.add(contact);
            FileUtility.saveObject("src/files/contacts.ser", contacts, StandardOpenOption.CREATE);
            System.out.println(contacts);
        }

    }

}
