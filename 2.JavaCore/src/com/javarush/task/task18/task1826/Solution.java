package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        String key = args[0];
        try (FileInputStream fileInputStream = new FileInputStream(args[1]);
             FileOutputStream fileOutputStream = new FileOutputStream(args[2])) {

            if (key.equals("-e")) {
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read() + 5);
                }
            } else if (key.equals("-d")){
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read() - 5);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
