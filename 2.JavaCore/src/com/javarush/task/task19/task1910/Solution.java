package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) {
        String filenameIn = "";
        String filenameOut = "";

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            filenameIn = bufferedReader.readLine();
            filenameOut = bufferedReader.readLine();
        } catch (IOException ignore) {
        }

        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filenameIn))){
            while (bufferedReader.ready()) {
                data.add(bufferedReader.readLine());
            }
        } catch (IOException ignore) {
        }


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filenameOut))) {
            for (String string : data) {
                bufferedWriter.write(string.replaceAll("\\p{Punct}", ""));
            }
        } catch (IOException ignore) {
        }
    }
}
