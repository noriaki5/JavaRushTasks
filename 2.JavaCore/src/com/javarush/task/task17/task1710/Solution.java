package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if (args.length == 0) return;

        if (args[0].equals("-c")) {
            String name = args[1];
            String sex = args[2];
            String bd = args[3];
            Date dateBD = new Date();
            boolean isMale = sex.equals("м");
            try {
                 dateBD = new SimpleDateFormat("dd/MM/yyyy").parse(bd);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (isMale) {
                allPeople.add(Person.createMale(name, dateBD));
            } else {
                allPeople.add(Person.createFemale(name, dateBD));
            }
            System.out.println(allPeople.size()-1);


        } else if (args[0].equals("-r")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            StringBuilder str = new StringBuilder();
            str.append(person.getName()).append(" ");
            str.append(person.getSex()==Sex.MALE ? "м " : "ж ");
            str.append(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate()));
            System.out.println(str);
        } else if (args[0].equals("-u")) {
            int id = Integer.parseInt(args[1]);
            String name = args[2];
            String sex = args[3];
            String bd = args[4];
            Date dateBD = new Date();
            boolean isMale = sex.equals("м");

            try {
                dateBD = new SimpleDateFormat("dd/MM/yyyy").parse(bd);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Person person = allPeople.get(id);
            person.setName(name);
            person.setSex(isMale ? Sex.MALE : Sex.FEMALE);
            person.setBirthDate(dateBD);
            //System.out.println(person.getName());

        } else if (args[0].equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
            //System.out.println(allPeople.size());
        }
    }


}
