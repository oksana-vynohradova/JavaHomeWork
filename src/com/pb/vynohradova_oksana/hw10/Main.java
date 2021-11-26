package com.pb.vynohradova_oksana.hw10;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        NumBox<Integer> intBox = new NumBox<>(10);
        NumBox<Float> floatBox = new NumBox<>(7);

        Random rand = new Random();
        // public void add
        for (int i = 0; i < 8; i++) {
            intBox.add(rand.nextInt(101));
        }

        for (int i = 0; i < 6; i++) {
            floatBox.add(rand.nextFloat() + rand.nextInt(100));
        }

        //public T get
        for (int i = 0; i < 10; i++) {
            System.out.println(intBox.get(i));
        }
        System.out.println("---------------------");
        for (int i = 0; i < 7; i++) {
            System.out.println(floatBox.get(i));
        }

        System.out.println("---------------------");
        //public int length
        System.out.println("Текущее количество элементов intBox: " + intBox.length());
        System.out.println("Текущее количество элементов floatBox: " + floatBox.length());

        System.out.println("---------------------");
        //public double average
        System.out.println("Среднее арифметическое intBox: " + intBox.average());
        System.out.println("Среднее арифметическое floatBox: " + floatBox.average());

        System.out.println("---------------------");
        //public double sum
        System.out.println("Сумма intBox: " + intBox.sum());
        System.out.println("Сумма floatBox: " + floatBox.sum());

        System.out.println("---------------------");
       //public T max
        System.out.println("Максимальный элемент intBox: " + intBox.max());
        System.out.println("Максимальный элемент floatBox: " + floatBox.max());
    }
}
