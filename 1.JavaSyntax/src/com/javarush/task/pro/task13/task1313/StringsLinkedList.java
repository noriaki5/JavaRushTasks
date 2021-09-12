package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        if (first.next == null) {
            Node newNode = new Node();
            newNode.value = value;
            first.next = newNode;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }

        Node newNode = new Node();
        newNode.value = value;

        Node lastNode = last.prev;
        lastNode.next = newNode;
        newNode.prev = lastNode;
        last.prev = newNode;

    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
