package com.pb.vynohradova_oksana.hw5;

/**
 * Класс Book хранит информацию о книге:
 * bookName - название
 * author - автор книги
 * pubYear - год издания
 */
public class Book {
    private static int countBooks = 0;
    private String bookName = "unknown";
    private String author = "unknown";
    private int pubYear = 9999;

    public Book(){
        countBooks++;
    }

    public Book(String bookName){
        this.bookName = bookName;
        countBooks++;
    }

    public Book(String bookName, String author){
        this(bookName);
        this.author = author;
    }

    public Book(String bookName, String author, int pubYear){
        this(bookName, author);
        this.pubYear = pubYear;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    /**
     * Проверяет сколько книг осталось и "выдает" книги
     * @param count  запрашиваемое кол-во книг
     * @return сколько выдано
     */
    public static int takeBooks(int count) {
        if (count <= countBooks) {
            countBooks -= count;
            return count;
        } else {
            int x = countBooks;
            countBooks = 0;
            return x;
        }
    }

    /**
     * Возвращает книги
     * @param count количество книг
     */
    public static void returnBooks(int count) {
        if (count > 0) {
            countBooks += count;
        }
    }

    public String getBookInfo (){
        return bookName + " (" + author + ", " + pubYear + " г.)";
    }

    /**
     * Сообщает количество книг в наличии
     */
    public static void bookBalance() {
        System.out.println("У нас осталось " + countBooks + " книг(а/и)");
    }

}
