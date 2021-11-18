package com.pb.vynohradova_oksana.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth auth = new Auth();
        Scanner q = new Scanner(System.in);

        String login = askLogin(q, true);
        String password = askPassword(q, true);
        String confirmPassword = askConfirmPassword(q);

        boolean res = false;
        do {
            try {
                res = auth.signUp(login, password, confirmPassword);
            } catch (WrongLoginException l) {
                System.out.println(l.getMessage() + System.lineSeparator());
                login = askLogin(q, true);
                password = askPassword(q, true);
                confirmPassword = askConfirmPassword(q);
            } catch (WrongPasswordException p) {
                System.out.println(p.getMessage() + System.lineSeparator());
                password = askPassword(q, true);
                confirmPassword = askConfirmPassword(q);
            } catch (RegistrationBreakException r) {
                System.out.println(r.getMessage());
                return;
            }
        } while (!res);

        final int MAXTRIES = 3;
        int attempt = 1;
        boolean enterRes = false;
        String enterLogin = askLogin(q, false);
        String enterPassword = askPassword(q, false);

        do {
            try {
                enterRes = auth.signIn(enterLogin, enterPassword);
            } catch (WrongLoginException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
                enterLogin = askLogin(q, false);
                enterPassword = askPassword(q, false);
                attempt++;
                if (attempt == 3) {
                    System.out.println("Вы исчерпали количество попыток входа. Ваш аккаунт заблокирован");
                }
            }
        } while (attempt < MAXTRIES && !enterRes);
    }

    static String askLogin(Scanner q, boolean registration) {
        if (registration) {
            System.out.println("Для регистрации введите логин" + System.lineSeparator() +
                    "Используйте только латинские буквы и цифры (5-20 символов)" +
                    " кроме сочетания \"exit\"" + System.lineSeparator() +
                    "Для прекращения регистрации введите \"exit\"");
        } else {
            System.out.println("Введите логин для входа");
        }
        return q.next();
    }

    static String askPassword(Scanner q, boolean registration) {
        if (registration) {
            System.out.println("Придумайте пароль" + System.lineSeparator() +
                    "Пароль может содержать только латинские буквы и цифры и знак подчеркивания" +
                    " (не менее 5 символов)");
        } else {
            System.out.println("Введите пароль для входа");
        }
        return q.next();
    }

    static String askConfirmPassword(Scanner q) {
        System.out.println("Для подтверждения повторите пароль");
        return q.next();
    }
}
