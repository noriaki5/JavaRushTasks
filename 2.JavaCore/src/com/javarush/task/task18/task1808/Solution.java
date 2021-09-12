package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.ArrayList;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream file1 = new FileInputStream(bufferedReader.readLine());
             FileOutputStream file2 = new FileOutputStream(bufferedReader.readLine());
             FileOutputStream file3 = new FileOutputStream(bufferedReader.readLine())) {

            ArrayList<Integer> inputData = new ArrayList<>();
            System.out.println(file1.available());
            while (file1.available() > 0) {
                inputData.add(file1.read());
            }
            System.out.println(inputData.size());
            for (int i = 0; i < inputData.size(); i++) {
                if (i < (inputData.size()+1)/2) {
                    file2.write(inputData.get(i));
                }
                else {
                    file3.write(inputData.get(i));
                }
            }

        } catch (IOException e) {

        }
    }
}
