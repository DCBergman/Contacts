package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtility {


    public static void saveObject(String filename, Object o, StandardOpenOption... option) {
        Path path = Paths.get(filename);
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path, option))) {
            out.writeObject(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}

