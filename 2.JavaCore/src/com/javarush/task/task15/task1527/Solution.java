package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String str = url.substring(url.indexOf("?")+1, url.length());
        String[] strings = str.split("&");
        boolean wasObj = false;
        String objValue = null;
        for (String s : strings) {
            String parameter = s.substring(0, s.contains("=") ? s.indexOf("="): s.length());
            System.out.println(parameter);
            if (parameter.equals("obj")) {
                wasObj = true;
                objValue = s.substring(s.indexOf("=")+1, s.length());
            }
        }
        if (wasObj) {
            try {
                alert((Double) Double.parseDouble(objValue));
            } catch (Exception e) {
                alert(objValue);
            }
        }
        reader.close();
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
