package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream file1 = new FileInputStream(bufferedReader.readLine());
            FileOutputStream file2 = new FileOutputStream(bufferedReader.readLine())) {

            ArrayList<Integer> inputData = new ArrayList<>();
            while (file1.available() > 0) {
                inputData.add(file1.read());
            }
            Collections.reverse(inputData);

            for (Integer cyrByte : inputData) {
                file2.write(cyrByte);
            }

        } catch (IOException e) {

        }
    }
}
