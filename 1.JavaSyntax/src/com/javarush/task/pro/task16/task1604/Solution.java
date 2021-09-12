package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1986, Calendar.DECEMBER, 31);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        String result;
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY: {
                result = "Понедельник";
                break;
            }
            case Calendar.TUESDAY: {
                result = "Вторник";
                break;
            }
            case Calendar.WEDNESDAY: {
                result = "Среда";
                break;
            }
            case Calendar.THURSDAY: {
                result = "Четверг";
                break;
            }
            case Calendar.FRIDAY: {
                result = "Пятница";
                break;
            }
            case Calendar.SATURDAY: {
                result = "Суббота";
                break;
            }
            case Calendar.SUNDAY: {
                result = "Воскресенье";
                break;
            }
            default: {
                result = "Неизвестный день недели";
            }
        }

        return result;
    }
}
