package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
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


        try (BufferedReader fileReader = new BufferedReader(new FileReader(filenameIn));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filenameOut))){
            while (fileReader.ready()) {
                char aChar = (char)fileReader.read();
                if (aChar == '.') aChar = '!';
                fileWriter.write(aChar);
            }
        } catch (IOException ignore) {
        }
    }
}
