package com.pb.vynohradova_oksana.hw13;

import java.util.Queue;
import java.util.Random;

public class Consumer implements Runnable {
    private final Queue<Integer> buffer;

    public Consumer(Queue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String color;
        while (true) {
            synchronized (buffer) {
                color = ProducerConsumer.color();
                if (buffer.isEmpty()) {
                    System.out.println(color + "Буфер пуст. " + Thread.currentThread().getName() + "ожидает.");
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    int x = buffer.poll();
                    System.out.println(color + Thread.currentThread().getName() + " извлек из буфера " + x);
                    System.out.println(color + "Буфер :" + buffer);
                    buffer.notifyAll();
                }
            }
            try {
                Thread.sleep(new Random().nextInt(5) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
