package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

import java.util.Objects;

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        @Override
        public int hashCode() {
            int result = 31*(getI()*getJ());
            return result + (name != null ? name.hashCode() : 0);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            B o = (B) obj;
            if (!Objects.equals(this.name, o.name)) return false;

            return (this.getI() == o.getI() && this.getJ() == o.getJ());
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            C obj = new C(super.getI(), super.getJ(), super.getName());
            return obj;
        }
    }

    public static void main(String[] args) {
        B bObj = new B(1, 2, "B");
        C cObj = new C(2,3, "C");
        try {
            C cClone = (C) cObj.clone();
            System.out.println(cObj);
            System.out.println(cClone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
