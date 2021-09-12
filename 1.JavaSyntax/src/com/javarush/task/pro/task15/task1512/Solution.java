package com.javarush.task.pro.task15.task1512;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/* 
Задом наперед
*/

public class Solution {
    public static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    public static PrintStream stream = new PrintStream(outputStream);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        printSomething(scanner.nextLine());
        String result = outputStream.toString();
        
        byte[] byteArray = outputStream.toByteArray();
        outputStream.reset();
        for (int i = byteArray.length-1; i >= 0; i--) {
            printSomething(String.valueOf((char)byteArray[i]));
        }
        result = outputStream.toString();
        System.out.println(result);

//        Версия со StringBuilder
//        outputStream.reset();
//        StringBuilder stringBuilder = new StringBuilder(result);
//        String reverse = stringBuilder.reverse().toString();
//        printSomething(reverse);
//        System.out.println(reverse);
    }

    public static void printSomething(String str) {
        stream.print(str);
    }
}