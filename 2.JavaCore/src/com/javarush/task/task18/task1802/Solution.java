package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        int min = Integer.MAX_VALUE;
        while (fileInputStream.available() > 0) {
            int currentByte = fileInputStream.read();
            if (currentByte < min) min = currentByte;
        }
        System.out.println(min);
        fileInputStream.close();
        bufferedReader.close();
    }
}
