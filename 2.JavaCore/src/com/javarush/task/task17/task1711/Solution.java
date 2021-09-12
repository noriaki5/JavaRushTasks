package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static SimpleDateFormat smdPrint = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    public static SimpleDateFormat smdInsert = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        if (args.length == 0) return;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        String name = args[i];
                        String sex = args[i + 1];
                        String bd = args[i + 2];
                        Date dateBD = new Date();
                        boolean isMale = sex.equals("м");
                        try {
                            dateBD = smdInsert.parse(bd);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (isMale) {
                            allPeople.add(Person.createMale(name, dateBD));
                        } else {
                            allPeople.add(Person.createFemale(name, dateBD));
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }
            case "-i": {
                synchronized (allPeople) {
                    for (int i=1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        StringBuilder str = new StringBuilder();
                        str.append(person.getName()).append(" ");
                        str.append(person.getSex() == Sex.MALE ? "м " : "ж ");
                        str.append(smdPrint.format(person.getBirthDate()));
                        System.out.println(str);
                    }
                    break;
                }
            }
            case "-u": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=4) {
                        int id = Integer.parseInt(args[i]);
                        String name = args[i+1];
                        String sex = args[i+2];
                        String bd = args[i+3];
                        Date dateBD = new Date();
                        boolean isMale = sex.equals("м");

                        try {
                            dateBD = smdInsert.parse(bd);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        Person person = allPeople.get(id);
                        person.setName(name);
                        person.setSex(isMale ? Sex.MALE : Sex.FEMALE);
                        person.setBirthDate(dateBD);
                        //System.out.println(person.getName());
                    }

                    break;
                }
            }
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                    break;
                }
            }
        }
    }

}
