package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.Arrays;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        String fileIn = args[0];
        String fileOut = args[1];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileIn));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut))) {
            while (bufferedReader.ready()) {
                String[] splitedLine = bufferedReader.readLine().split(" ");
                Arrays.stream(splitedLine).forEach(s->{if (s.matches(".*\\d.*")) {
                    try {
                        bufferedWriter.write(s+" ");
                    } catch (IOException e) {
                    }
                }
                });
                splitedLine[0].matches("\\d");
            }

        } catch (IOException ignore) {
        }
    }
}
