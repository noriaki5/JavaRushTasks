package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
             Scanner scannerFile = new Scanner(fileInputStream)) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (scannerFile.hasNext()) {
                int number = scannerFile.nextInt();
                if (number % 2 == 0) {
                    arrayList.add(number);
                }
            }
            Collections.sort(arrayList);
            arrayList.forEach(System.out::println);
//            byte[] bytes = fileInputStream.readAllBytes();
//            ArrayList<Integer> arrayList = new ArrayList<>();
//
//            StringBuilder str = new StringBuilder();
//            for (int i=0; i < bytes.length; i++) {
//                if (bytes[i] != 13 && bytes[i] != 10) {
//                    str.append((char) bytes[i]);
//                }
//                else if (bytes[i] == 10){
//                    int number = Integer.parseInt(str.toString());
//                    if (number % 2 == 0) {
//                        arrayList.add(number);
//
//                    }
//                    str.delete(0, str.length());
//                }
//            }
//            if (!str.isEmpty()) {
//                arrayList.add(Integer.parseInt(str.toString()));
//            }
//            arrayList.sort(Integer::compareTo);
//            arrayList.forEach(System.out::println);
        }


    }
}
