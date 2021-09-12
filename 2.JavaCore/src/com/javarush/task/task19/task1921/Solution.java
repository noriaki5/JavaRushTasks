package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        String filename = args[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while (bufferedReader.ready()) {
                String[] strings = bufferedReader.readLine().split(" ");
                StringBuilder name = new StringBuilder();
                for (int i = 0; i < strings.length - 3; i++) {
                    name.append(strings[i]).append(" ");
                }
                int year = Integer.parseInt(strings[strings.length-1]);
                int month = Integer.parseInt(strings[strings.length-2]) -1;
                int day = Integer.parseInt(strings[strings.length-3]);
                Calendar calendar = new GregorianCalendar(year, month, day);
                Date birthday = calendar.getTime();
                Person person = new Person(name.toString().trim(), birthday);
                PEOPLE.add(person);
            }

        } catch (IOException e) {
        }
        PEOPLE.forEach(person -> System.out.println(person.getName()+" "+person.getBirthDate()));
    }
}
