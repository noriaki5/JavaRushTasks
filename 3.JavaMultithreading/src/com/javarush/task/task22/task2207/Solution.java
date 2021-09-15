package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        String filename = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            filename = bufferedReader.readLine();
        } catch (IOException ignore) {
        }
        List<String> wordsList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while (bufferedReader.ready()) {
                String[] splitedLine = bufferedReader.readLine().split(" ");
                wordsList.addAll(Arrays.asList(splitedLine));
            }
            for (int i = 0; i < wordsList.size(); i++) {
                for (int j = i + 1; j < wordsList.size(); ) {
                    if (i >= wordsList.size()) break;

                    if (wordsList.get(i).equals(new StringBuilder(wordsList.get(j)).reverse().toString()) && i != j ) {
                        Pair newPair = new Pair(wordsList.get(i), wordsList.get(j));
                        result.add(newPair);
                        wordsList.remove(j);
                        wordsList.remove(i);
                        j = i + 1;
                    } else {
                        j++;
                    }
                }
            }

//            for (Iterator<String> iterator = wordsList.iterator(); iterator.hasNext(); ) {
//                String str = iterator.next();
//                String reversedStr = new StringBuilder(str).reverse().toString();
//                int reversedIndex = wordsList.indexOf(reversedStr);
//                if (reversedIndex != -1) {
//                    Pair newPair = new Pair(str, reversedStr);
//                    result.add(new Pair(str, reversedStr));
//                    iterator.remove();
//                    wordsList.remove(reversedIndex);
//                }
////                if (wordsList.contains(reversedStr)) {
////                    Pair newPair = new Pair(str, reversedStr);
////                    Pair reversedPair = new Pair(reversedStr, str);
////                    if (!result.contains(newPair) && !result.contains(reversedPair)) {
////                        result.add(new Pair(str, reversedStr));
////                    }
////                }
//            }

        } catch (IOException ignore) {
        }
        result.forEach(System.out::println);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
