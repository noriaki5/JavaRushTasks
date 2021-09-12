package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        long[] result = null;

        ArrayList<Long> arrayList = new ArrayList<>();

        for (long i = 0; i < N; i++) {
            char[] charNumbers = Long.toString(i).toCharArray();
            //String[] strNumbers = Long.toString(i).split("\\d");
            long sum = 0;
            int m = charNumbers.length;
            for (int j = 0; j < m ; j++) {
                sum += (long) Math.pow(Double.parseDouble(String.valueOf(charNumbers[j])), m);

            }
            if (sum == i) {
                arrayList.add(i);
            }
        }
        result = arrayList.stream().mapToLong(i -> i).toArray();

        return result;
    }


    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
