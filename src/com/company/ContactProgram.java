package com.company;

import javax.management.relation.Role;
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
                        Scanner input = new Scanner(System.in);
                        System.out.println("\nPress Enter to continue");
                        input.nextLine();
                        break;
                    case VIEW_CONTACTS_BY_CAT:
                        input = new Scanner(System.in);
                        System.out.println("Please contact category: ");
                        String contactCategory = input.nextLine();
                        viewContactsByCat(contactCategory);
                        System.out.println("\nPress Enter to continue");
                        input.nextLine();
                        break;
                    case FIND_CONTACT:
                        input = new Scanner(System.in);
                        System.out.println("\nPlease enter name of contact: ");
                        String name = input.nextLine();
                        findContact(name);
                        break;
                    case EDIT_CONTACT:
                        int i = 1;
                        System.out.println("Please enter the number of the contact you wish to edit. \n" +
                                "--------------------------\n");
                        for (Contact c : contacts ) {
                            System.out.println(i + ". " + c.getName());
                            i++;
                        }
                        input = new Scanner(System.in);
                        int contactIndex = input.nextInt() - 1;
                        String infoType = EditContactMenu.getInstance().showMenuAndGetChoice();
                        editContact(contactIndex, infoType);
                        break;
                    case REMOVE_CONTACT:
                         i = 1;
                        System.out.println("Please enter the number of the contact you wish to remove. \n" +
                                "--------------------------\n");
                        for (Contact c : contacts) {
                            System.out.println(i + ". " + c.getName() + " " + c.getPhoneNumber());
                            i++;
                        }
                        input = new Scanner(System.in);
                        int index = input.nextInt() - 1;
                        removeContact(index);
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
            System.out.println(contact.getName() + " has been added. \nPlease press enter to continue. ");
            Scanner input = new Scanner(System.in);
            input.nextLine();
        }

    }
    public void findContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                c.showInfo();

                Scanner input = new Scanner(System.in);
                System.out.println("Press Enter to continue");
                input.nextLine();

            }
        }
    }
    public void editContact(int index, String info){
        Scanner input = new Scanner(System.in);
       Contact contact = contacts.get(index);
       Contact decoratedContact;
        if(info == "Address"){
            System.out.println("Address: ");
             String address = input.nextLine();
            decoratedContact = new AddressDecorator(new InfoDecorator(contact), address);
            if (decoratedContact != null) {
                contacts.set(index, decoratedContact);
            }
        }
        if(info == "Relationship"){
            System.out.println("Relationship: ");
            String relationship = input.nextLine();
            decoratedContact = new RelationshipDecorator(new InfoDecorator(contact), relationship);
            if (decoratedContact != null) {
                contacts.set(index, decoratedContact);
            }
        }
        if(info == "Role"){
            System.out.println("Role: ");
            String role = input.nextLine();
            decoratedContact = new RoleDecorator(new InfoDecorator(contact), role);
            if (decoratedContact != null) {
                contacts.set(index, decoratedContact);
            }
        }
        if(info == "Company"){
            System.out.println("Company: ");
            String company = input.nextLine();
            decoratedContact = new CompanyDecorator(new InfoDecorator(contact), company);
            if (decoratedContact != null) {
                contacts.set(index, decoratedContact);
            }
        }
            FileUtility.saveObject("src/files/contacts.ser", contacts, StandardOpenOption.CREATE);
            System.out.println(contact.getName() + " has been updated. \nPlease press enter to continue. ");
            input = new Scanner(System.in);
            input.nextLine();
    }
    public void removeContact(int index){
        String name = contacts.get(index).getName();
        contacts.remove(index);
        System.out.println(name + " has been removed from your contacts.");
        Scanner input = new Scanner(System.in);
        System.out.println("Press Enter to continue");
        input.nextLine();
    }
    public void viewContactsByCat(String contactCat){
        int i =0;
        for (Contact c: contacts) {
            if(c.toString().toLowerCase().contains(contactCat.toLowerCase())){
                c.showInfo();
                i++;
            }
        }
        if(i == 0 ){
            System.out.println("You have no contacts of that type in your list.");
        }

    }

}
