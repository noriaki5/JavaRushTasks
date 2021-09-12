package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = null;
        //FileReader fileReader = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                filename = bufferedReader.readLine();
                try (FileReader fileReader = new FileReader(filename)) {

                } catch (FileNotFoundException e) {
                    System.out.println(filename);
                    break;
                }
            }
        } catch (IOException e) {


        }
    }
}
