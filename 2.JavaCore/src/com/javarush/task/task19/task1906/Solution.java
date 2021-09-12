package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputFile = bufferedReader.readLine();
            String outputFile = bufferedReader.readLine();
            FileReader fileReader = new FileReader(inputFile);
            FileWriter fileWriter = new FileWriter(outputFile);
            int count = 1;
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (fileReader.ready()) {
                if (count % 2 == 0) {
                    //list.add(fileReader.read());
                    fileWriter.write(fileReader.read());
                }
                else {
                    fileReader.read();
                }
                count++;
            }
            fileReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
