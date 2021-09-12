package com.javarush.task.task19.task1918;


import java.io.*;
import java.util.ArrayList;
import java.util.Stack;


/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {
        String filename = "";
        String tag = args[0];
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            filename = bufferedReader.readLine();
        } catch (IOException e) {
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine());
            }
        } catch (IOException e) {
        }
        String str = stringBuilder.toString().replaceAll("\\r\\n", "");
        ArrayList<Integer> startIndexes = new ArrayList<>();
        ArrayList<Integer> endIndexes = new ArrayList<>();
        int index = 0;
        while (index != -1) {
            index = str.indexOf("<"+tag, index);
            if (index != -1) {
                startIndexes.add(index);
                index++;
            }

        }
        index = 0;
        while (index != -1) {
            index = str.indexOf("</"+tag+">", index);
            if (index != -1) {
                endIndexes.add(index + tag.length() + 3); //</> <- this 3 chars
                index++;
            }
        }
//        System.out.println(startIndexes);
//        System.out.println(endIndexes);
        Stack<String> stack = new Stack<>();
        for (int i = startIndexes.size() -1; i >= 0 ; i--) {
            stack.push(str.substring(startIndexes.get(i), getNextCloseTag(endIndexes, startIndexes.get(i))));
            //System.out.println(str.substring(startIndexes.get(i), getNextCloseTag(endIndexes, startIndexes.get(i))));
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    private static int getNextCloseTag(ArrayList<Integer> endIndexes, int currentOpenIndex) {
        for (int i = 0; i < endIndexes.size(); i++) {
            int current = endIndexes.get(i);
            if (endIndexes.get(i) > currentOpenIndex) {
                endIndexes.remove(i);
                return current;
            }
        }
        return 0;
    }
}
