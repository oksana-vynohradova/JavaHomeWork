package com.pb.vynohradova_oksana.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);
        System.out.println("Введите целое число");
        String answer = q.nextLine();
        int answ;
        String res;

        try {
            answ = Integer.parseInt(answer.trim());
        } catch (Exception e) {
            System.out.println("Это не число или не целое. Попробуйте еще раз");
            return;
        }
        answ = Integer.parseInt(answer.trim());

        if (0 <= answ && answ <= 14) {
            res = "[0-14]";
        } else if (15 <= answ && answ <= 35) {
            res = "[15-35]";
        } else if (36 <= answ && answ <= 50) {
            res = "[36-50]";
        } else if (51 <= answ && answ <= 100) {
            res = "[51-100]";
        } else {
            System.out.println("Число не входит ни в один из имеющихся промежутков");
            return;
        }

        System.out.println("Ваше число находится в промежутке " + res);
    }
}