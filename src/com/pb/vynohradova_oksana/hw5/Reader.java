package com.pb.vynohradova_oksana.hw5;

import java.util.Arrays;

/**
 * Класс Reader хранит информацию о пользователе библиотеки:
 * fio - ФИО
 * passNumber - номер читательского билета
 * faculty - факультет
 * dateBirth - дата рождения
 * phoneNumber - телефон
 */
public class Reader {
    private static int countReaders = 0;
    private String passNumber = "AA";
    private String fio = "unknown";
    private String faculty = "unknown";
    private String dateBirth = "01-01-9999";
    private String phoneNumber = "unknown";

    public Reader(){
        countReaders++;
        passNumber += countReaders;
    }

    public Reader(String fio, String dateBirth) {
        this.fio = fio;
        this.dateBirth = dateBirth;
        countReaders++;
        passNumber += countReaders;
    }

    public Reader(String fio, String dateBirth, String faculty) {
        this(fio, dateBirth);
        this.faculty = faculty;
    }

    public Reader(String fio, String dateBirth, String faculty, String phoneNumber){
        this(fio, dateBirth, faculty);
        this.phoneNumber = phoneNumber;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReaderInfo() {
        return "Читатель: " + fio + " " + dateBirth + " г.р., факультет: " + faculty
                + ", читательский билет №" + passNumber + ", контактный номер: " + phoneNumber;
    }

    /**
     * Обращается в Book за книгами и сообщает результат выдачи
     * @param count запрашиваемое количество книг
     */
    public void takeBook(int count) {
        int takenBooks = Book.takeBooks(count);
        if (takenBooks != 0) {
            String message = "";
            if (takenBooks != count) {
                message = " Больше не было";
            }
            System.out.println(fio + " взял " + takenBooks + " книг(и)." + message);
        } else {
            System.out.println(fio + " ничего не взял. Книги кончились.");
        }
    }

    /**
     * Обращается в Book за книгами и сообщает результат выдачи
     * @param bookNames Наименования запрашиваемых книг
     */
    public void takeBook(String... bookNames){
        int takenBooks = Book.takeBooks(bookNames.length);
        StringBuilder sb = new StringBuilder();
        if (takenBooks == bookNames.length) {
            System.out.println(fio + " взял книги: " + Arrays.toString(bookNames).replaceAll("\\[|\\]","") + ".");
        } else if (takenBooks != 0){
            for (int i = 0; i < takenBooks; i++) {
                sb.append(bookNames[i]).append(", ");
            }
            sb.replace(sb.length() - 2, sb.length() - 1, ". Больше не было.");
            System.out.println(fio + " взял книги: " + sb);
        } else {
            System.out.println(fio + " ничего не взял. Книги кончились.");
        }
    }

    /**
     * Обращается в Book за книгами и сообщает результат выдачи
     * @param books запрашиваемые книги
     */
    public void takeBook(Book... books) {
        int takenBooks = Book.takeBooks(books.length);
        StringBuilder sb = new StringBuilder();
        String str = ".";
        if (takenBooks != 0) {
            for (int i = 0; i < takenBooks; i++) {
                sb.append(books[i].getBookInfo()).append(", ");
                if (takenBooks != books.length) {
                    str = ". Больше не было.";
                }
                sb.replace(sb.length() - 2, sb.length() - 1, str);
            }
            System.out.println(fio + "взял книги: " + sb);
        } else {
            System.out.println(fio + " ничего не взял. Книги кончились.");
        }
    }

    /**
     * Возвращает книги в Book
     * @param count количество возрата
     */
    public void returnBook(int count) {
        Book.returnBooks(count);
        if (count > 0) {
            System.out.println(fio + " вернул " + count + " книг(и)");
        } else {
            System.out.println(fio + " ничего не вернул. Зачем приходил - не понятно.");
        }
    }

    /**
     * Возвращает книги в Book
     * @param bookNames наименования возвращаемых книг
     */
    public void returnBook(String... bookNames) {
        Book.returnBooks(bookNames.length);
        System.out.println(fio + " вернул книгу(и): " + Arrays.toString(bookNames).replaceAll("\\[|\\]","") + ".");
    }

    /**
     * Возвращает книги в Book
     * @param books возвращаемые книги
     */
    public void returnBook(Book... books) {
        Book.returnBooks(books.length);
        StringBuilder sb = new StringBuilder();
        for (Book book:books) {
            sb.append(book.getBookInfo()).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length() - 1, ".");
        System.out.println(fio + " вернул книгу(и): " + sb);
    }
}
