package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream original = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(original);

        String[] strings = byteArrayOutputStream.toString().split(" ");
        int arg1 = Integer.parseInt(strings[0]);
        int arg2 = Integer.parseInt(strings[2]);
        String sign = strings[1];
        switch (sign) {
            case "+" : {
                System.out.print(byteArrayOutputStream.toString() + (arg1 + arg2));
                break;
            }
            case "-" : {
                System.out.print(byteArrayOutputStream.toString() + (arg1 - arg2));
                break;
            }
            case "*" : {
                System.out.print(byteArrayOutputStream.toString() + (arg1 * arg2));
                break;
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

