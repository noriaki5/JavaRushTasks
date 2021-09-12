package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        String outputFile;
        TreeSet<String> treeSet = new TreeSet<>((o1, o2) -> {
            String[] split1 = o1.split(".part");
            String[] split2 = o2.split(".part");
            int o1index = Integer.parseInt(split1[split1.length - 1]);
            int o2index = Integer.parseInt(split2[split2.length - 1]);
            return o1index - o2index;
        });
        while (!(filename = bufferedReader.readLine()).equals("end")) {
            treeSet.add(filename);
        }
        int partIndex = treeSet.first().lastIndexOf(".part");
        outputFile = treeSet.first().substring(0, partIndex);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        for (String str : treeSet) {
            try (FileInputStream fileInputStream = new FileInputStream(str)){
                byte[] buffer = new byte[fileInputStream.available()];
                while (fileInputStream.available() > 0) {
                    int bytesRead = fileInputStream.read(buffer);
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
            }
        }
        fileOutputStream.close();
    }
}
