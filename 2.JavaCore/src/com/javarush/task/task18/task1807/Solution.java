package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine())) {
            char input;
            char comma = ',';
            int commaCount = 0;
            while (fileInputStream.available() > 0) {
                if ((input = (char)fileInputStream.read()) == comma) {
                    commaCount++;
                }

            }
            System.out.println(commaCount);
        } catch (IOException e) {

        }
    }
}
