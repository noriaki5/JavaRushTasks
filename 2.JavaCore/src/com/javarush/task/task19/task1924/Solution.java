package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        String filename = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            filename = bufferedReader.readLine();
        } catch (IOException ignore) {
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    line = line.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                }
                System.out.println(line);
            }
//            while (bufferedReader.ready()) {
//                String line = bufferedReader.readLine();
//                String[] words = line.split("\\b");
//
//                for (String word : words) {
//
//                    if (word.matches("\\d") && map.containsKey(Integer.parseInt(word))) {
//                        line = line.replace(word, map.get(Integer.parseInt(word)));
//
//                    }
//                }
//
//                System.out.println(line);
//            }
        } catch (IOException ignore) {
        }
    }
}
