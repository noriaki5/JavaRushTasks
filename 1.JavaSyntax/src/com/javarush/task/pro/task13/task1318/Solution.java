package com.javarush.task.pro.task13.task1318;

/* 
Следующий месяц, пожалуйста
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getNextMonth(Month.JANUARY));
        System.out.println(getNextMonth(Month.DECEMBER));
    }

    public static Month getNextMonth(Month month) {
        int count = Month.values().length;
        //Month[] monthAll = Month.values();
        if (month.ordinal()+1 >= count)
            return Month.values()[month.ordinal()+1-count];
        else
            return Month.values()[month.ordinal()+1];
    }
}
