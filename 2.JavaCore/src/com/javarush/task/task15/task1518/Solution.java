package com.javarush.task.task15.task1518;

/* 
Статики и котики
*/

public class Solution {
    public static Cat cat;

    public static class Cat {
        public String name;

        static {
            Solution.cat = new Cat();
            cat.name = "Barsik";
            System.out.println(cat.name);

        }
    }

    public static void main(String[] args) {
        cat = new Cat();
    }
}
