package com.pb.vynohradova_oksana.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);
        System.out.println("Введите целое число");
        int operand1 = q.nextInt();
        System.out.println("И еще одно");
        int operand2 = q.nextInt();
        System.out.println("Что делаем? (+,-,*,/)");
        String sign = q.next();

        float res;
        switch (sign) {
            case "+":
                res = operand1 + operand2;
                break;
            case "-":
                res = operand1 - operand2;
                break;
            case "*":
                res = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    res = (float) operand1 / (float) operand2;
                } else {
                    System.out.println("Ой-ой. На 0 делить нельзя");
                    return;
                }
                break;
            default:
                System.out.println("Так не пойдет. Попробуйте еще раз");
                return;
        }

        if (sign.equals("/")) {
            System.out.println("Получилось: " + res);
        } else System.out.println("Получилось: " + (int)res);
    }
}