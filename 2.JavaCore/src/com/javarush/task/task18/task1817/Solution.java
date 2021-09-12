package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader(args[0])) {
            ArrayList<Character> allData = new ArrayList<>();
            long spaceCount = 0;
            while (fileReader.ready()) {
                allData.add((char) fileReader.read());
            }
            spaceCount = allData.stream().filter(s->s==' ').count();
            System.out.printf("%5.2f", spaceCount*1d/allData.size()*100);
        } catch (IOException e) {

        }
    }
}
