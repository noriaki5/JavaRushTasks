package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    private int countOfPassengers;

    @Override
    public void fly() {

    }
    public Plane(int count) {
        this.countOfPassengers = count;
    }
}
