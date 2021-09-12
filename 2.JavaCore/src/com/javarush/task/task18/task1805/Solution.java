package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine())) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (fileInputStream.available() > 0) {
                arrayList.add(fileInputStream.read());
            }
            arrayList.stream().distinct().sorted(Integer::compareTo).forEach(s->System.out.print(s + " "));
        }
    }
}
