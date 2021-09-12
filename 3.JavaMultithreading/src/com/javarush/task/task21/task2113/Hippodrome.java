package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse aHorse: horses) {
            aHorse.move();
        }
    }

    public void print() {
        for (Horse aHorse: horses) {
            aHorse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        return horses.stream().max((d1, d2) -> Double.compare(d1.getDistance(), d2.getDistance())).get();
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {

        List<Horse> horses = new ArrayList<>();
        Horse horse1 = new Horse("Chuck", 3, 0);
        Horse horse2 = new Horse("Lorry", 3, 0);
        Horse horse3 = new Horse("Winner", 3, 0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}

