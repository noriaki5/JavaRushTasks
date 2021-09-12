package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
//        words.add("файл");
//        words.add("вид");
//        words.add("В");
        words.add("А");
        words.add("Б");
        words.add("В");
    }

    public static void main(String[] args) {
        String filename = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            filename = bufferedReader.readLine();
        } catch (IOException e) {
        }

        try (BufferedReader inData = new BufferedReader(new FileReader(filename))) {
            while (inData.ready()) {
                String line = inData.readLine();
                String[] splitedLine = line.split(" ");
                int wordsCount = 0;
                for (String str : splitedLine) {
                    if (words.contains(str)) {
                        wordsCount++;
                    }
                }
                if (wordsCount == 2) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
        }
    }
}
