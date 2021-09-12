package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String filenameIn = bufferedReader.readLine();
            String filenameOut = bufferedReader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(filenameIn));
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) {
                stringBuilder.append((char) fileReader.read());
            }
            String[] strings = stringBuilder.toString().split(" ");
            StringBuilder result = new StringBuilder();
            for (String string : strings) {
                try {
                    int number = Integer.parseInt(string);
                    result.append(number).append(" ");
                } catch (NumberFormatException ignored) {

                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filenameOut));
            bufferedWriter.write(result.toString().trim());

            fileReader.close();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
