package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());

        int max = Integer.MIN_VALUE;
        while (fileInputStream.available() > 0) {
            int currentByte = fileInputStream.read();
            if (currentByte > max) max = currentByte;
        }
        System.out.println(max);
        bufferedReader.close();
        fileInputStream.close();
    }
}
