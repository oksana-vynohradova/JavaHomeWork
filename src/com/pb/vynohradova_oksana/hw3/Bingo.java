package com.pb.vynohradova_oksana.hw3;

import java.util.Random;
import java.util.Scanner;

/*Программа должна загадать целое число в диапазоне от 0 до 100 и предложить пользователю его отгадать.
При вводе числа пользователем, программа проверяет на соответствие с загаданным число и если числа совпали вывести сообщение о том, что число отгадано.
Если числа не совпали, тогда следует вывести надпись о том, что задуманное число является больше или меньше вводимого.
Также программа ведет подсчет попыток, и выводит это количество gпосле того как число угадали.
Предусмотреть возможность досрочного завершения программы, в случае если пользователь не желает продолжать угадывать число.
 */
public class Bingo {
    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);
        Random rand = new Random();
        int x = rand.nextInt(101);
        int counter = 0;
        boolean game = true;
        int answ;

        System.out.println("Добро пожаловать в Бинго! Попробуйте отгадать мое число от 0 до 100");
        System.out.println("Для завершения игры введите exit");

        do {
            System.out.println("Ваш ответ?");
            String answer = q.next();

            if (answer.equals("exit")) {
                System.out.println("Победа была так близко...");
                break;
            }

            counter++;

            try {
                answ = Integer.parseInt(answer.trim());
            } catch (Exception e) {
                System.out.println("Так не пойдет. Введите число от 0 до 100");
                continue;
            }
            answ = Integer.parseInt(answer.trim());

            String cmp;

            if (x == answ) {
                game = false;
                System.out.println("Ура! Победа! Мое число действительно было: " + x);
                System.out.println("Количество использованных попыток: " + counter);
                break;
            } else if (answ < 0 || answ > 100) {
                System.out.println("Угадываем число от 0 до 100. Выбирайте из этого промежутка.");
                continue;
            } else if (x < answ) {
                cmp = "меньше";
            } else {
                cmp = "больше";
            }

            int step = Math.abs(x - answ);
            String hint;
            if (step >= 50) {
                hint = "Холодно. ";
            } else if (step >= 25) {
                hint = "Тепло. ";
            } else if (step >= 10) {
                hint = "Горячо. ";
            } else {
                hint = "Почти угадали. ";
            }
            System.out.println(hint + "Но мое число " + cmp);
        }
        while (game);




        System.out.println("Конец игры");
    }
}
