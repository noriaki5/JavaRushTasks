package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = bufferedReader.readLine();
            if (str.equals("exit")) {
                break;
            }
            try {
                if (str.contains(".")) {
                    print(Double.parseDouble(str));
                } else {
                    int integer = Integer.parseInt(str);
                    if (integer > 0 && integer < 128) {
                        print((short) integer);
                    } else {
                        print(integer);
                    }
                }
            } catch (Exception e) {
                print(str);
            }

//            boolean onlyDigits = true;
//            for (int i = 0; i < str.length(); i++) {
//                if (str.charAt(i) != '-' && !Character.isDigit(str.charAt(i))) {
//                    onlyDigits = false;
//                    break;
//                }
//            }
//
//            if (str.contains(".")) {
//                print(Double.parseDouble(str));
//            } else if (!onlyDigits) {
//                print(str);
//            } else {
//                int integer = Integer.parseInt(str);
//                if (integer > 0 && integer < 128) {
//                    print((short) integer);
//                } else {
//                    print(integer);
//                }
//            }
        }
        bufferedReader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
