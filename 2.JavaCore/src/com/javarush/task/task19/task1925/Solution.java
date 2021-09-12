package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        String fileIn = args[0];
        String fileOut = args[1];
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileIn))) {
            while (bufferedReader.ready()) {
                String[] splitedLine = bufferedReader.readLine().split(" ");
                for (String word : splitedLine) {
                    if (word.length() > 6) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException ignore) {
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut))) {
            for (int i = 0; i < result.size(); i++) {
                if (i < result.size() -1) {
                    bufferedWriter.write(result.get(i) + ",");
                }
                else {
                    bufferedWriter.write(result.get(i));
                }
            }
        } catch (IOException ignore) {
        }
    }
}
