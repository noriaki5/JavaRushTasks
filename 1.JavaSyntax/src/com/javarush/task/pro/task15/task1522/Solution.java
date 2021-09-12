package com.javarush.task.pro.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://javarush.ru/api/1.0/rest/projects");
        try {
            InputStream inputStream = url.openStream();
            byte[] buffer = inputStream.readAllBytes();
            String str = new String(buffer);
            System.out.println(str);
        }
        catch (Exception e) {

        }
    }
}