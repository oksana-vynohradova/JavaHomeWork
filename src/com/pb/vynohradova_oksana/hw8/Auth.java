package com.pb.vynohradova_oksana.hw8;

public class Auth {
    private String login;
    private String password;
    private static final String WRONSYMBOLMSG = "Используйте только разрешенные символы";
    private static final String WRONGLENGTHMSG = "Недопустимая длина";

    public boolean signUp(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException, RegistrationBreakException {
        if (login.equalsIgnoreCase("exit")
            || password.equalsIgnoreCase("exit")
            || confirmPassword.equalsIgnoreCase("exit")) {
            throw new RegistrationBreakException("Регистрация прервана.");
        }

        boolean regStatus;
        if (login.matches("^[A-Za-z0-9]+$")) {
            if (login.length() > 4 && login.length() < 21) {
                this.login = login;
            } else {
                throw new WrongLoginException(WRONGLENGTHMSG + " логина");
            }
        } else {
            throw new WrongLoginException(WRONSYMBOLMSG);
        }

        if (password.matches("^[A-Za-z0-9_]+$")) {
            if (password.length() > 4) {
                this.password = password;
            } else {
                throw new WrongPasswordException(WRONGLENGTHMSG + " пароля");
            }
        } else {
            throw new WrongPasswordException(WRONSYMBOLMSG);
        }

        if (confirmPassword.equals(this.password)) {
            regStatus = true;
            System.out.println("Поздравляем с успешной регистрацией" + System.lineSeparator());
        } else {
            throw new WrongPasswordException("Введенные пароли не совпадают");
        }
        return regStatus;
    }

    public boolean signIn(String login, String password) throws WrongLoginException {
        boolean enterStatus;
        if (login.equals(this.login) && password.equals(this.password)) {
            enterStatus = true;
            System.out.println("Добро пожаловать, " + login + "!");
        } else {
            throw new WrongLoginException("Неверное имя пользователя или пароль");
        }
        return enterStatus;
    }
}
