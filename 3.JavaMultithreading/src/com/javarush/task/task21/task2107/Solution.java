package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    public Solution clone() throws CloneNotSupportedException {
        Solution o = (Solution) super.clone();
        Map<String , User> newUsers = new LinkedHashMap<>();
        o.users.forEach((k,v)->{
            try {
                newUsers.put(k, (User) v.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });
        o.users = newUsers;
        return o;
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public int hashCode() {
            int result = age;
            return  31 * result + (name != null ? name.hashCode() : 0);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            User user = (User) obj;
            if (this.age != user.age) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }
    }
}
