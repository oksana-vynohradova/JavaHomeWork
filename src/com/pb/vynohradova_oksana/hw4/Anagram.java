package com.pb.vynohradova_oksana.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);
        System.out.println("Введите первое предложение");
        String text1 = q.nextLine().toLowerCase();
        System.out.println("Введите второе предложение");
        String text2 = q.nextLine().toLowerCase();

        if (text1.isEmpty() || text2.isEmpty()) {
            System.out.println("Вы передали пустую строку");
        } else {

            boolean result = compareTexts(text1, text2);

            if (result) {
                System.out.println("Это однозначно анаграмма");
            } else System.out.println("К сожалению, это НЕ анаграмма");
        }
    }

    //вариант 2 - работает для любого языка
    static boolean compareTexts (String t1, String t2) {
        char[] first = t1.toCharArray();
        char[] second = t2.toCharArray();
        Arrays.sort(first);
        t1 = delNotLetters(first);
        Arrays.sort(second);
        t2 = delNotLetters(second);

        return t1.equals(t2);
    }

    static String delNotLetters (char[] array) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            if (Character.isLetter(array[i])) str.append(array[i]);
        }
        return str.toString();
    }

    //первоначальный вариант - только англ, рус, укр
//    static boolean compareTexts (String t1, String t2) {
//        t1 = t1.replaceAll("[^a-zа-яёіїєґ]", "");
//        t2 = t2.replaceAll("[^a-zа-яёіїєґ]", "");
//        if (t1.length() != t2.length()) {
//            return false;
//        }
//
//        char[] first = t1.toCharArray();
//        Arrays.sort(first);
//        char[] second = t2.toCharArray();
//        Arrays.sort(second);
//        boolean compare = Arrays.equals(first, second);
//        return compare;
//    }
}
