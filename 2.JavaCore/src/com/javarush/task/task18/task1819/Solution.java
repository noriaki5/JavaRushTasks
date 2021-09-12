package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String file1 = bufferedReader.readLine();
            String file2 = bufferedReader.readLine();
            ArrayList<Integer> file1Data = new ArrayList<>();
            FileReader file1Reader = new FileReader(file1);
            while (file1Reader.ready()) {
                file1Data.add(file1Reader.read());
            }
            file1Reader.close();
            FileReader file2Reader = new FileReader(file2);
            FileWriter file1Writer = new FileWriter(file1);
            while (file2Reader.ready()) {
                file1Writer.write(file2Reader.read());
            }
            file2Reader.close();
            for (Integer curByte : file1Data) {
                file1Writer.write(curByte);
            }
            file1Writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
