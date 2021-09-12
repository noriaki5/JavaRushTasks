package com.javarush.task.pro.task15.task1507;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scan = new Scanner(System.in);
             ) {
            List<String> lines = Files.readAllLines(Paths.get(scan.nextLine()));
            int i = 0;
            for (String s : lines) {
                if (i % 2 == 0) {
                    System.out.println(s);
                }
                i++;
            }
        }
        catch (IOException e) {
            System.out.println("Something went wrong: " + e);
        }
    }
}

