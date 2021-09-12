package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        String filename = "";
        final String keyword = "world";

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            filename = bufferedReader.readLine();
        } catch (IOException ignored) {

        }

        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(filename)) {
            while (fileReader.ready()) {
                stringBuilder.append((char) fileReader.read());
            }
        } catch (IOException ignored) {

        }
        Pattern pattern = Pattern.compile("\\b"+keyword+"\\b");
        Matcher matcher = pattern.matcher(stringBuilder.toString());
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
    }
}
