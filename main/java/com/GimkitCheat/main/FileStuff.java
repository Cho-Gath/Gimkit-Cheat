package com.GimkitCheat.main;

import java.io.*;
import java.util.HashMap;

public class FileStuff implements java.io.Serializable{

    public static String PATH = ".\\stuff\\answers.ser";

    public static HashMap read() {
        HashMap map;
        try {
            FileInputStream fileIn = new FileInputStream(PATH);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            map = (HashMap) in.readObject();
            in.close();
            return (map);
        } catch(IOException e) {
            System.out.println("IOException in read");
            return null;
        } catch(ClassNotFoundException e) {
            return null;
        }
    }


    public static void save(HashMap map) {
        try {
            FileOutputStream fileOut = new FileOutputStream(PATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(map);
            out.close();
            fileOut.close();
        } catch(FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("IOException in write");
        }

    }
}
