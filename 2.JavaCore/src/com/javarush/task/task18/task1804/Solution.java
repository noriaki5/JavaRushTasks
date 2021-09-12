package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
            int[] byteCounter = new int[256];
            while (fileInputStream.available() > 0) {
                byteCounter[fileInputStream.read()]++;
            }
            int minByte = Integer.MAX_VALUE;
            for (int curByte : byteCounter) {
                if (curByte < minByte && curByte > 0) minByte = curByte;
            }
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < byteCounter.length; i++) {
                if (byteCounter[i] == minByte) {
                    result.add(i);
                }
            }
            result.forEach(s->System.out.print(s + " "));
            fileInputStream.close();
        }
    }
}
