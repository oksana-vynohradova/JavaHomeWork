package com.pb.vynohradova_oksana.hw5;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book();
        books[1] = new Book("Приключения", "Иванов И. И.", 2000);
        books[2] = new Book("Словарь", "Сидоров А. В.", 1980);
        books[3] = new Book("Энциклопедия", "Гусев К. В.", 2010);
        books[4] = new Book("Дюна", "Фрэнк Герберт");

        System.out.println("Список книг:");
        for (Book book:books) {
            System.out.println(book.getBookInfo());
        }

        Reader[] readers = new Reader[4];
        readers[0] = new Reader("Первый П.П.", "15-01-1985");
        readers[1] = new Reader("Второй В.В.", "10-04-1987", "Журналистики");
        readers[2] = new Reader("Третий Т.Т.","23-08-1990", "Философии", "0991234567");
        readers[3] = new Reader();

        System.out.println(System.lineSeparator() + "Список пользователей библиотеки:");
        for (Reader reader:readers){
            System.out.println(reader.getReaderInfo());
        }

        readers[0].takeBook(2);
        readers[1].takeBook("Приключения", "Словарь");
        readers[2].takeBook(books[3], books[4]);
        readers[3].takeBook(books[3], books[4]);


        readers[0].returnBook(1);
        readers[1].returnBook("Приключения", "Словарь");
        readers[2].returnBook(books[3], books[4]);

        Book.bookBalance();
    }
}
