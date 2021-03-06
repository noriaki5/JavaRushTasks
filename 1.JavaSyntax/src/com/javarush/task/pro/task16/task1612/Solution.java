package com.javarush.task.pro.task16.task1612;

import java.security.KeyStore;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        Set<LocalDateTime> localDateTimes = new HashSet<>();
        for (Map.Entry<LocalDate, List<LocalTime>> pair : sourceMap.entrySet()) {
            for (LocalTime currentTime : pair.getValue()) {
                localDateTimes.add(LocalDateTime.of(pair.getKey(), currentTime));
            }
        }

        return localDateTimes;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}