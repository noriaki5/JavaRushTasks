package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        while (!(filename = bufferedReader.readLine()).equals("exit")) {
            new ReadThread(filename).start();
        }
        System.out.println(resultMap.toString());
    }

    public static class ReadThread extends Thread {
        private String filename;

        public ReadThread(String fileName) {
            this.filename = fileName;
        }

        @Override
        public void run() {

            try (FileInputStream fileInputStream = new FileInputStream(filename)) {
                byte[] bytes = new byte[256];
                while (fileInputStream.available() > 0) {
                    bytes[fileInputStream.read()]++;
                }
                int maxCount = 0;
                int maxCountByte = 0;
                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] > maxCount) {
                        maxCount = bytes[i];
                        maxCountByte = i;
                    }
                }
                resultMap.put(filename, maxCountByte);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
