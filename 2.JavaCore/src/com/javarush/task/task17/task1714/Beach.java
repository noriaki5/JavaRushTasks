package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    @Override
    public synchronized int compareTo(Beach o) {
        int distanceCondition;
        int qualityCondition;
        if (this.distance == o.getDistance()) {
            distanceCondition = 0;
        } else if (this.distance < o.getDistance()) {
            distanceCondition = 1;
        } else {
            distanceCondition = -1;
        }
        if (this.quality == o.getQuality()) {
            qualityCondition = 0;
        } else if (this.quality > o.getQuality()) {
            qualityCondition = 1;
        } else {
            qualityCondition = -1;
        }
        return distanceCondition+qualityCondition;
    }

    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach beach1 = new Beach("b1", 10, 30);
        Beach beach2 = new Beach("b2", 20, 30);
        System.out.println(beach1.compareTo(beach2));
    }
}
