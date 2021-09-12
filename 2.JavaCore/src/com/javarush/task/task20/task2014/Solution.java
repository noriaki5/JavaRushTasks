package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) {
        Solution savedObject = new Solution(4);
        Solution loadedObject = new Solution(4);

        String filename = "c:/2014.txt";
        try (FileInputStream fileInputStream = new FileInputStream(filename);
             FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(savedObject);
            oos.close();
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            loadedObject = (Solution) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ignore) {
        }
        System.out.println(savedObject.string.equals(loadedObject.string));

    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
