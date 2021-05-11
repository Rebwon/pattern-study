package com.rebwon.design.chap2.practice;

import java.util.LinkedList;

public final class Queue extends LinkedList<String> {

    public boolean addQueue(String e) {
        return add(e);
    }

    public String removeQueue() {
        return removeFirst();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.addQueue("apple");
        queue.addQueue("kiwi");

        System.out.println(queue.removeQueue());
        System.out.println(queue.removeQueue());
    }
}
