package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put("name", "Ivanov");
        parameters.put("country", "Ukraine");
        parameters.put("city", "Kiev");
        parameters.put("age", null);
        System.out.println(getQuery(parameters));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry: params.entrySet()) {
            if (entry.getValue() != null) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(" and ");
                }
                stringBuilder.append(entry.getKey())
                        .append(" = '")
                        .append(entry.getValue())
                        .append("'");
            }
        }
        return stringBuilder.toString();
    }
}
