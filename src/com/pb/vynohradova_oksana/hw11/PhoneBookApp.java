package com.pb.vynohradova_oksana.hw11;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.*;

public class PhoneBookApp {
    private static PhoneBook<Contact> phoneBook = new PhoneBook<>();

    public static void main(String[] args) {
        //для тестов
        String[] array = {"0991234567", "+380677654321"};
        String[] array2 = {"12345, 474950, 584903"};
        Contact c1 = new Contact("Ева", new ArrayList<>(Arrays.asList(array)), "Киев");
        Contact c2 = new Contact("Оксана", new ArrayList<>(Arrays.asList(array2)), LocalDate.of(1991, 6, 25), "Днепр");
        Contact c3 = new Contact("Кот Василий", new ArrayList<>(Arrays.asList(array)), LocalDate.of(1907,3,7));
        phoneBook.add(c1);
        phoneBook.add(c2);
        phoneBook.add(c3);

        System.out.println("Добро пожаловать!" + System.lineSeparator());
        Scanner scanner = new Scanner(System.in);

        startScreen(scanner);
    }

    static void startScreen(Scanner s) {
        String[] commands = {"add", "delete", "search", "output", "edit", "write", "upload", "exit"};
        System.out.println("Доступные команды приложения \"Телефонная книга\":" + System.lineSeparator()
                + "\"Добавить контакт\" введите add" + System.lineSeparator()
                + "\"Удалить контакт\" введите delete" + System.lineSeparator()
                + "\"Поиск контакта\" введите search" + System.lineSeparator()
                + "\"Вывод всех контактов на экран\" введите output" + System.lineSeparator()
                + "\"Отредактировать контакт\" введите edit" + System.lineSeparator()
                + "\"Записать контакты в файл\" введите write" + System.lineSeparator()
                + "\"Загрузить контакты из файла\" введите upload" + System.lineSeparator()
                + "для выхода введите exit");

        String answer = s.next().trim().toLowerCase();
        while (!Arrays.asList(commands).contains(answer)) {
            System.out.println("Выберите одну из предложенных команд");
            answer = s.next();
        }
        ActionSelect(answer, s);
    }

    static void ActionSelect(String action, Scanner s) {
        switch (action) {
            case "add":
                addContact(s);
                break;
            case "delete":
                deleteContact(s);
                break;
            case "search":
                searchContact(s);
                break;
            case "output":
                outputContacts(s);
                break;
            case "edit":
                editContact(s);
                break;
            case "write":
                writePhoneBook(s);
                break;
            case "upload":
                uploadPhoneBook(s);
                break;
            case "exit":
                System.out.println("Пока!");
        }
    }

    static void toContinue(Scanner s) {
        System.out.println(System.lineSeparator() + "Хотите продолжить? (Y/N)");
        String answer = s.next();
        if (answer.equals("Y")) {
            startScreen(s);
        } else ActionSelect("exit", s);
    }

    static void addContact(Scanner s) {
        System.out.println("Добавление контакта:" + System.lineSeparator()
                + "Имя");
        String name = s.next().trim();
        s.nextLine();

        System.out.println("Номер(а) телефонов через запятую");
        String numbs = s.nextLine();

        while (numbs.isEmpty()) {
            System.out.println("Внесите хотя бы один номер телефона");
            numbs = s.nextLine();
        }

        ArrayList<String> numbers = new ArrayList<>(Arrays.asList(numbs.split(", ")));

        System.out.println("Дата рождения контакта в формате \"YYYY-MM-dd\" (не обязательно). " +
                "Для пропуска нажмите enter");
        String strDate = s.nextLine();
        LocalDate date = checkDate(strDate);

        System.out.println("Адрес контакта (не обязательно). Для пропуска нажмите enter");
        String address = s.nextLine();

        if (address.isEmpty() && date == null) {
            phoneBook.add(new Contact(name, numbers));
        } else if (date == null) {
            phoneBook.add(new Contact(name, numbers, address));
        } else if (address.isEmpty()) {
            phoneBook.add(new Contact(name, numbers, date));
        } else {
            phoneBook.add(new Contact(name, numbers, date, address));
        }

        System.out.println("Контакт успешно добавлен");
        toContinue(s);
    }

    static LocalDate checkDate(String d) {
        Scanner scan = new Scanner(System.in);
        LocalDate localDate = null;
        if (!d.isEmpty()) {
            boolean checkDate;
            do {
                checkDate = true;
                try {
                    localDate = LocalDate.parse(d);
                } catch (Exception e2) {
                    checkDate = false;
                    System.out.println("Введите год, месяц, день числами в формате \"YYYY-MM-dd\""
                            + System.lineSeparator()
                            + "(Месяц от 1 до 12, день от 1 до 28/31)");
                    d = scan.nextLine();
                }
            } while (!checkDate);
        }
        return localDate;
    }

    static void deleteContact(Scanner s) {
        System.out.println("Введите имя контакта, который хотите удалить");
        String delName = s.next().trim();
        phoneBook.removeByName(delName);
        System.out.println("Контакт " + delName + " удален.");
        toContinue(s);
    }

    static void searchContact(Scanner s) {
        s.nextLine();
        System.out.println("Введите имя контакта для поиска");
        String searchName = s.nextLine().trim();

        while (searchName.isEmpty()) {
            System.out.println("Имя не может быть пустым. Введите имя контакта для поиска");
            searchName = s.nextLine().trim();
        }

        Contact result = phoneBook.searchByName(searchName);
        if (result == null) {
            System.out.println("Контакт отсутствует в телефонной книге");
        } else {
            System.out.println("Контак найден:" + System.lineSeparator()
                    + result);
        }
        toContinue(s);
    }

    static void outputContacts(Scanner s) {
        System.out.println("Выберите параметр из списка, по которому хотите сортировать вывод:"
                + System.lineSeparator()
                + "name - по имени," + System.lineSeparator()
                + "nameIgnoreCase - по имени, игнорируя регистр," + System.lineSeparator()
                + "birth - по дате рождения," + System.lineSeparator()
                + "address - по адресу," + System.lineSeparator()
                + "editing - по времени редактирования");
        String sortParam = s.next().trim().toLowerCase();
        PhoneBook<Contact> sortedPHBook = phoneBook.sortByParam(sortParam);
        System.out.println(sortedPHBook);
        toContinue(s);
    }

    static void editContact(Scanner s) {
        s.nextLine();
        System.out.println("Укажите имя контакта, который необходимо отредактировать");
        String contactName = s.nextLine().trim();

        while (contactName.isEmpty()) {
            System.out.println("Имя не может быть пустым. Введите имя контакта");
            contactName = s.nextLine().trim();
        }

        Contact contact = phoneBook.searchByName(contactName);
        if (contact == null) {
            System.out.println("Контакт отсутствует в телефонной книге");
        } else {
            System.out.println("Выберите редактируемое поле:" + System.lineSeparator()
                    + "name" + System.lineSeparator()
                    + "dateOfBirth" + System.lineSeparator()
                    + "phoneNumbers" + System.lineSeparator()
                    + "address");
            String paramEdit = s.next().trim();

            switch (paramEdit) {
                case "name":
                    System.out.println("Введите новое имя контакта");
                    String newName = s.next().trim();
                    contact.setPerson(newName, true);
                    break;
                case "dateOfBirth":
                    System.out.println("Введите новую дату рождения в формате \"YYYY-MM-dd\"");
                    String strDate = s.next().trim();
                    LocalDate date = checkDate(strDate);
                    contact.setDateOfBirth(date);
                    break;
                case "address":
                    System.out.println("Введите новый адрес");
                    String newAddress = s.next().trim();
                    contact.setAddress(newAddress);
                    break;
                case "phoneNumbers":
                    String oldNumber = contact.getNumber(0);
                    if (contact.numbersLength() != 1) {
                        System.out.println("Какой номер хотите отредактировать?" + System.lineSeparator()
                                + contact.getPhoneNumbers());
                        oldNumber = s.next().trim();
                    }
                    System.out.println("Введите новый номер");
                    String newNumber = s.next().trim();
                    contact.editPhoneNumber(oldNumber, newNumber);
                    break;
                default:
                    System.out.println("Поле для редактирования не опозннано");
                    toContinue(s);
                    return;
            }
            System.out.println("Данные успешно отредактированы");
        }
        toContinue(s);
    }

    static void writePhoneBook (Scanner s) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                                    .setPrettyPrinting()
                                    .registerTypeAdapter(Contact.class, new ContactConverter())
                                    .registerTypeAdapter(PhoneBook.class, new PhoneBookConverter());
        Gson gson = gsonBuilder.create();
        try (Writer writer = new FileWriter("files\\hw11_phoneBook.json")) {
            writer.write(gson.toJson(phoneBook));
            System.out.println("Запись в файл \"hw11_phoneBook.json\" завершена");
        } catch (Exception e) {
            System.out.println("Произошла ошибка записи в файл." + Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
        }
        toContinue(s);
    }

    static void uploadPhoneBook(Scanner s) {
        try (FileReader reader = new FileReader("files\\hw11_phoneBook.json")) {
            GsonBuilder gsonBuilder = new GsonBuilder()
                                        .registerTypeAdapter(Contact.class, new ContactConverter())
                                        .registerTypeAdapter(PhoneBook.class, new PhoneBookConverter());
            Gson gson = gsonBuilder.create();
            phoneBook = gson.fromJson(reader, PhoneBook.class);
            //System.out.println(phoneBook);
            System.out.println("Данные успешно загружены.");
        } catch (Exception e) {
            System.out.println(e);
        }

        toContinue(s);
    }
}

