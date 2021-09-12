package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();
        StringBuilder lines = new StringBuilder();
        while (true) {
            StringBuilder line = new StringBuilder(bufferedReader.readLine());
            lines.append(line).append("\n");
            if (line.toString().equals("exit")) {
                break;
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write(lines.toString());
        bufferedWriter.close();
    }
}
