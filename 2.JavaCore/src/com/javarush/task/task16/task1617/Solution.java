package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

import javax.swing.plaf.TableHeaderUI;

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            while (numSeconds>0) {
                System.out.print(numSeconds + " ");
                numSeconds--;
                try {
                    Thread.sleep(1000);
                    if (numSeconds == 0) {
                        System.out.print("Марш!");
                    }
                } catch (InterruptedException e) {
                    System.out.print("Прервано!");
                }

            }
        }
    }
}
