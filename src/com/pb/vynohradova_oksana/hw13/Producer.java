package com.pb.vynohradova_oksana.hw13;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
    private final Queue<Integer> buffer;

    public Producer(Queue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String color;
        while (true) {
            synchronized (buffer) {
                color = ProducerConsumer.color();
                if (buffer.size() >= 5) {
                    System.out.println(color + "Буфер полон. " + Thread.currentThread().getName() + " ожидает.");
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    int x = new Random().nextInt(1001);
                    buffer.add(x);
                    System.out.println(color + Thread.currentThread().getName() + " записал в буфер " + x);
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
