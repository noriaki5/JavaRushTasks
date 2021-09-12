package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {
        String filename = args[0];
        TreeMap<String, Double> treeMap = new TreeMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while (bufferedReader.ready()) {
                String[] strings = bufferedReader.readLine().split(" ");
                treeMap.put(strings[0], treeMap.getOrDefault(strings[0], 0d)+Double.parseDouble(strings[1]));
            }
        } catch (IOException e) {
        }

        double max = Collections.max(treeMap.values());
        treeMap.forEach((k,v)-> {if (v == max) System.out.println(k);} );
    }
}
