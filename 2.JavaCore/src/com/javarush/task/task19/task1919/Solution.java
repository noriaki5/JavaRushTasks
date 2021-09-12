package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        String filename = args[0];
        TreeMap<String, Double> treeMap = new TreeMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while (bufferedReader.ready()) {
                String[] strings = bufferedReader.readLine().split(" ");
                treeMap.put(strings[0], treeMap.getOrDefault(strings[0], 0d)+Double.parseDouble(strings[1]));
//                if (!treeMap.containsKey(strings[0])) {
//                    treeMap.put(strings[0], Double.parseDouble(strings[1]));
//                }
//                else {
//                    treeMap.put(strings[0], treeMap.get(strings[0]) + Double.parseDouble(strings[1]));
//                }
            }
        } catch (IOException e) {
        }
        treeMap.forEach((k,v)-> System.out.println(k + " " +v));
    }
}
