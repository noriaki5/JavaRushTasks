package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
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

        String filename = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            filename = bufferedReader.readLine();
        } catch (IOException ignore) {
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            System.out.println(byteArrayOutputStream.toString());
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
        } catch (IOException ignore) {
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

