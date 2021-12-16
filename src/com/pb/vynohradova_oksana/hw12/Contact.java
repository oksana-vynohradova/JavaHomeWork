package com.pb.vynohradova_oksana.hw12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Contact {
    private String person;
    private LocalDate dateOfBirth;
    private final ArrayList<String> phoneNumbers = new ArrayList<>();
    private String address;
    private LocalDateTime editing;

    public Contact(String person, ArrayList<String> phoneNumbers) {
        this.editing = LocalDateTime.now();
        this.person = person;
        this.phoneNumbers.addAll(phoneNumbers);
    }

    public Contact(String person, ArrayList<String> phoneNumbers, LocalDate date) {
       this(person, phoneNumbers);
        this.dateOfBirth = date;
    }

    public Contact(String person, ArrayList<String> phoneNumbers, String address) {
        this(person, phoneNumbers);
        this.address = address;
    }

    public Contact(String person, ArrayList<String> phoneNumbers, LocalDate date,
                   String address) {
        this(person, phoneNumbers, address);
        this.dateOfBirth = date;
    }

    public String getPerson() {
        return person;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getNumber(int index) {
        return phoneNumbers.get(index);
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getEditing() {
        return editing;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.editing = LocalDateTime.now();
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.editing = LocalDateTime.now();
        this.address = address;
    }

    public void setEditing(LocalDateTime editing) {
        this.editing = editing;
    }

    public void setPerson(String person, boolean change) {
        if (change) {
            this.editing = LocalDateTime.now();
        }
        this.person = person;
    }

    public void editPhoneNumber(String oldNumber, String newNumber) {
        this.editing = LocalDateTime.now();
        int index = this.phoneNumbers.indexOf(oldNumber);
        if (index != -1) {
            this.phoneNumbers.set(index, newNumber);
        } else {
            this.phoneNumbers.add(newNumber);
        }
    }

    public int numbersLength() {
        return phoneNumbers.size();
    }

    @Override
    public String toString() {
        return '{' + System.lineSeparator() +
                "\tИмя: " + person + "," + System.lineSeparator() +
                "\tДата рождения: " + dateOfBirth + "," + System.lineSeparator() +
                "\tНомера телефонов: " + phoneNumbers + "," + System.lineSeparator() +
                "\tАдрес: " + address + "," + System.lineSeparator() +
                "\tПоследнее редактирование: " + editing + System.lineSeparator() +
                '}';
    }
}
