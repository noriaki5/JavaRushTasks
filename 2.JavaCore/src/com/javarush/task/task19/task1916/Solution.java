package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        String filename1 = "";
        String filename2 = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            filename1 = bufferedReader.readLine();
            filename2 = bufferedReader.readLine();
        } catch (IOException ignore) {
        }
        List<String> file1Data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename1))) {
            while (bufferedReader.ready()) {
                file1Data.add(bufferedReader.readLine());
            }
        } catch (IOException ignore) {
        }
        List<String> file2Data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename2))) {
            while (bufferedReader.ready()) {
                file2Data.add(bufferedReader.readLine());
            }
        } catch (IOException ignore) {
        }
        int count = 0;
        while (true) {
            if (file1Data.size() == 0 && file2Data.size() == 0) {
                break;
            } else if (file1Data.size() == 0) {
                lines.add(new LineItem(Type.ADDED, file2Data.get(0)));
                file2Data.remove(0);
                continue;
            } else if (file2Data.size() == 0) {
                lines.add(new LineItem(Type.REMOVED, file1Data.get(0)));
                file1Data.remove(0);
                continue;
            }
            if (file1Data.get(0).equals(file2Data.get(0))) {
                lines.add(new LineItem(Type.SAME, file1Data.get(0)));
                file1Data.remove(0);
                file2Data.remove(0);
            } else if (file1Data.get(0).equals(file2Data.get(1))) {
                lines.add(new LineItem(Type.ADDED, file2Data.get(0)));
                file2Data.remove(0);
            } else if (file1Data.get(1).equals(file2Data.get(0))) {
                lines.add(new LineItem(Type.REMOVED, file1Data.get(0)));
                file1Data.remove(0);
            }
            count++;
        }
        System.out.println(lines.toString());
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type.toString() + " " + line;
        }
    }
}
