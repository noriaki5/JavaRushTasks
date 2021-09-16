package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        String filename = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            filename = bufferedReader.readLine();
        } catch (IOException ignore) {
        }
        String[] splitedLine = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            splitedLine = bufferedReader.readLine().split(" ");
        } catch (IOException ignore) {
        }


        StringBuilder result = getLine(splitedLine);

        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) return new StringBuilder();

        List<String> wordsArray = new ArrayList<>(Arrays.asList(words));
        StringBuilder result = new StringBuilder();
        List<String> resultArray = new ArrayList<>();
        result.append(wordsArray.get(0)).append(" ");
        resultArray.add(wordsArray.get(0));

        for (int i = 0; i < wordsArray.size() - 1; i++) {
            String word = resultArray.get(i);
            String letter = word.substring(word.length() - 1);
            for (int j = 0; j < wordsArray.size(); j++) {
                if (letter.equalsIgnoreCase(wordsArray.get(j).substring(0,1)) && !word.equals(wordsArray.get(j))) {
                    result.append(wordsArray.get(j)).append(" ");
                    resultArray.add(wordsArray.get(j));
                    break;
                }
            }
        }

        return result;
    }
}
