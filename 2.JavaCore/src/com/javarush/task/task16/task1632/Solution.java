package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new InfinityThread());
        threads.add(new InterruptedThread());
        threads.add(new UraThread());
        threads.add(new MessageThread());
        threads.add(new SummaryThread());
    }

    public static void main(String[] args) {
        threads.forEach(Thread::start);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        threads.forEach(Thread::interrupt);
        //((MessageThread)threads.get(0)).showWarning();

    }

    public static class InfinityThread extends Thread {
        @Override
        public void run() {
            while (true) {
                //Thread.sleep(100);
            }

        }
    }

    public static class InterruptedThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class UraThread extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    public static class MessageThread extends Thread implements Message {
        private boolean isCancel = false;

        @Override
        public void run() {

            while (!isCancel) {
                System.out.println(getName() + " is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
        }

        @Override
        public void showWarning() {
            isCancel = true;

        }
    }

    public static class SummaryThread extends Thread {
        @Override
        public void run() {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                int sum = 0;
                String str;
                while ( !(str = bufferedReader.readLine()).equals("N")) {
                    sum += Integer.parseInt(str);
                }
                System.out.println(sum);
            } catch (IOException e) {

            }
        }
    }
}