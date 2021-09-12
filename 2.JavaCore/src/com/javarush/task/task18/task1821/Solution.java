package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        String filename = args[0];
        try (FileReader fileReader = new FileReader(filename)) {
            TreeMap<Character, Integer> treeMap = new TreeMap<>();
            while (fileReader.ready()) {
                Character aChar = (char)fileReader.read();

                treeMap.put(aChar, treeMap.containsKey(aChar) ? treeMap.get(aChar)+1 : 1);

            }
            //System.out.println(treeMap);
            treeMap.forEach((k,v) -> System.out.println(k +" " +v));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
