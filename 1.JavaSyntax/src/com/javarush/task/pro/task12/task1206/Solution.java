package com.javarush.task.pro.task12.task1206;

/* 
Анализ строк
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Думаю, это будет новой фичей." +
                "Только не говорите никому, что она возникла случайно.";

        System.out.println("Количество цифр в строке : " + countDigits(string));
        System.out.println("Количество букв в строке : " + countLetters(string));
        System.out.println("Количество пробелов в строке : " + countSpaces(string));
    }

    public static int countDigits(String string) {
        int digitsCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i)))
                digitsCount++;
        }
        return digitsCount;
    }

    public static int countLetters(String string) {
        int lettersCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i)))
                lettersCount++;
        }
        return lettersCount;
    }

    public static int countSpaces(String string) {
        int spacesCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isSpaceChar(string.charAt(i)))
                spacesCount++;
        }
        return spacesCount;
    }
}
