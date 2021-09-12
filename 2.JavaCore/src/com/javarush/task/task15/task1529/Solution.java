package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = bufferedReader.readLine();
            if (str.equals("plane")) {
                int count = Integer.parseInt(bufferedReader.readLine());
                result = new Plane(count);
            }
            else if (str.equals("helicopter")) {
                result = new Helicopter();
            }
        }
        catch (Exception e) {

        }
    }
}
