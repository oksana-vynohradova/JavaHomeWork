package com.pb.vynohradova_oksana.hw13;

import java.util.ArrayDeque;
import java.util.Queue;

public class ProducerConsumer {

    public static void main(String[] args) {
        Queue<Integer> buffer = new ArrayDeque<>();
        Thread prod1 = new Thread(new Producer(buffer), "Producer-1");
        Thread prod2 = new Thread(new Producer(buffer), "Producer-2");
        Thread prod3 = new Thread(new Producer(buffer), "Producer-3");

        Thread cons1 = new Thread(new Consumer(buffer), "Consumer-1");
        Thread cons2 = new Thread(new Consumer(buffer), "Consumer-2");
        Thread cons3 = new Thread(new Consumer(buffer), "Consumer-3");

        prod1.start();
        prod2.start();
        prod3.start();

        cons1.start();
        cons2.start();
        cons3.start();
    }

    public static String color() {
        switch (Thread.currentThread().getName()) {
            case "Producer-1":
                return "\u001B[31m";
            case "Producer-2":
                return "\u001B[32m";
            case "Producer-3":
                return "\u001B[34m";
            case "Consumer-1":
                return "\u001B[33m";
            case "Consumer-2":
                return "\u001B[35m";
            case "Consumer-3":
                return "\u001B[36m";
            default:
                return "\u001B[37m";
        }
    }
}
