package com.pb.vynohradova_oksana.hw10;

import java.util.Arrays;

public class NumBox <T extends Number> {
    private final T[] numbers;

    @SuppressWarnings("unchecked")
    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }

    /**
     * Наполняет массив. Если массив полон, выбрасывает UnsupportedOperationException
     * @param num добавляемый элемент
     */
    public void add(T num) throws UnsupportedOperationException {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == null) {
                numbers[i] = num;
                break;
            } else if (i == numbers.length - 1) {
                throw new UnsupportedOperationException("No available space in the array");
            }
        }
    }

    /**
     *
     * @param index индекс
     * @return элемент массива по индексу index
     */
    public T get(int index){
        return numbers[index];
    }

    /**
     *
     * @return текущее количество элементов
     */
    public int length() {
        int count = 0;
        for (T n : numbers) {
            if (n != null) {
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @return среднее арифметическое элементов массива
     */
    public double average() {
        return this.sum()/this.length();
    }

    /**
     *
     * @return сумма всех элементов массива
     */
    public double sum() {
        double sum = 0;
        for (T n : numbers) {
            if (n != null) {
                sum += n.doubleValue();
            }
        }
        return sum;
    }

    /**
     *
     * @return максимальный элемент массива
     */
    public T max() {
        T[] nums = Arrays.copyOf(numbers, this.length());
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }
}
