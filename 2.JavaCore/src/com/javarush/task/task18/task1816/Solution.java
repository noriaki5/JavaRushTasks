package com.javarush.task.task18.task1816;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader(args[0])) {
            ArrayList<Character> list = new ArrayList<>();
            while (fileReader.ready()) {
                list.add((char) fileReader.read());
            }
            System.out.println(list.stream().filter(s->(s>='A' && s<='Z') || (s>='a' && s<='z')).count());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
