package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties properties = new Properties();
        //runtimeStorage.forEach((k,v) -> properties.put(k, v));
        properties.putAll(runtimeStorage);
        properties.store(outputStream, "#");

    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        runtimeStorage = properties.entrySet()
                .stream()
                .collect(
                        Collectors.toMap(e->e.getKey().toString(),
                                e->e.getValue().toString())
                );
    }

    static {
        runtimeStorage.put("Ivanov", "Ivan");
        runtimeStorage.put("Petrova", "Irina");
    }

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("c:/2003.txt")) {
            save(fos);
        } catch (Exception ignore) {
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
