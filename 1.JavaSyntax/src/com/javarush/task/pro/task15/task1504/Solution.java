package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             InputStream file1 = Files.newInputStream(Paths.get(scanner.nextLine()));
             OutputStream file2 = Files.newOutputStream(Paths.get(scanner.nextLine()))) {
            byte[] buffer = new byte[2];
            while (file1.available() > 0) {
                int real = file1.read(buffer);
                if (real % 2 == 0) {
                    file2.write(buffer[1]);
                    file2.write(buffer[0]);
                }
                else {
                    file2.write(buffer[0]);
                }

            }

        }
        catch (IOException e) {
            System.out.println("Something went wrong: " + e);
        }
    }
}

