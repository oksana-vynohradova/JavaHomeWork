package com.pb.vynohradova_oksana.hw3;

import java.util.Arrays;
import java.util.Scanner;

/*
Программа должна позволить пользователю ввести одномерный массив целых чисел размерностью 10 элементов.
Вывести на экран введенный массив.
Подсчитать сумму всех элементов массива и вывести ее на экран.
Подсчитать и вывести на экран количество положительных элементов.
Произвести сортировку этого массива от меньшего к большему по алгоритму сортировки пузырьком.
Вывести на экран отсортированный массив.
 */
public class Array {
    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);
        int[] array = new int[10];
        int sum = 0;
        int positive = 0;
        System.out.println("Давайте создадим массив. Введите 10 целых чисел");

        for (int i = 0; i < 10; i++) {
            System.out.println((i+1) + "-й:");
            if (q.hasNextInt()) {
                array[i] = q.nextInt();
                sum += array[i];
                if (array[i] > 0) {
                    positive++;
                }
            } else {
                System.out.println("Используйте только целые числа. Попробуем еще раз...");
                i--;
                q.next();
            }
        }

        int [] array2 = Arrays.copyOf(array, 10);
        boolean sort = false;
        int x;
        while (!sort) {
            sort = true;
            for (int j = 0; j < array2.length - 1; j++) {
                if (array2[j] > array2[j+1]) {
                    x = array2[j];
                    array2[j] = array2[j+1];
                    array2[j+1] = x;
                    sort = false;
                }
            }
        }

        System.out.println("Наш массив: " + Arrays.toString(array) + System.lineSeparator()
                + "Сумма элементов массива: " + sum + System.lineSeparator()
                + "Всего " + positive + " положительных элементов" + System.lineSeparator()
                + "Отсортируем: " + Arrays.toString(array2));
    }
}
