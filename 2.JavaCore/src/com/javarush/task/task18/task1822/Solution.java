package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int id = Integer.parseInt(args[0]);
        try (FileReader fileReader = new FileReader(bufferedReader.readLine());
             Scanner scanner = new Scanner(fileReader)) {

            while (scanner.hasNext()) {
                String[] input = scanner.nextLine().split(" ");
                if (Integer.parseInt(input[0]) == id) {
                    Arrays.stream(input).forEach(s -> System.out.print(s + " "));
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
