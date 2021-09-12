package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            arrayList.add(fileInputStream.read());
        }
        Map<Integer, Long> map = arrayList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long maxCount = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) maxCount = entry.getValue();
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }

        result.forEach(s->System.out.print(s+" "));
        fileInputStream.close();
        bufferedReader.close();
    }
}
