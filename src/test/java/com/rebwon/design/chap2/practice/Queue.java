package com.rebwon.design.chap2.practice;

import java.util.LinkedList;

public final class Queue {
    private LinkedList<String> list = new LinkedList<>();

    public boolean addQueue(String e) {
        return list.add(e);
    }

    public String removeQueue() {
        return list.removeFirst();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.addQueue("apple");
        queue.addQueue("kiwi");

        System.out.println(queue.removeQueue());
        System.out.println(queue.removeQueue());
    }
}
