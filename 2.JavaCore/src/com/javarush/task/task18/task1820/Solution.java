package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename1));
             PrintWriter printWriter = new PrintWriter(filename2)) {

            while (fileReader.ready()) {
                String[] strings = fileReader.readLine().split(" ");
                for (String str : strings) {
                    double doubleValue = Double.parseDouble(str);
                    long roundedValue = Math.round(doubleValue);
                    printWriter.write(roundedValue + " ");
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        bufferedReader.close();
    }
}
