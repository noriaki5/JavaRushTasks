package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter file1 = new FileWriter(bufferedReader.readLine(), true);
             FileReader file2 = new FileReader(bufferedReader.readLine());
             FileReader file3 = new FileReader(bufferedReader.readLine())) {
            while (file2.ready()) {
                file1.write(file2.read());
            }
            while (file3.ready()) {
                file1.write(file3.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
