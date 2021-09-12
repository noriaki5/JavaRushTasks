package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName;
            while (true) {
                fileName = bufferedReader.readLine();
                FileInputStream fileInputStream = new FileInputStream(fileName);
                if (fileInputStream.available() < 1000 && fileInputStream.available() != -1) {
                    fileInputStream.close();
                    throw new DownloadException();
                }
                fileInputStream.close();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
