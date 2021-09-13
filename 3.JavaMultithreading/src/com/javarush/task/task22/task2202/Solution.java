package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        String[] splitedStr = string.split(" ");
        if (splitedStr.length < 5) throw new TooShortStringException();
        return splitedStr[1] + " " +
                splitedStr[2] + " " +
                splitedStr[3] + " " +
                splitedStr[4];
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
