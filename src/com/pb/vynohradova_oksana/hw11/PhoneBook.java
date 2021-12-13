package com.pb.vynohradova_oksana.hw11;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneBook<T extends Contact> extends ArrayList<Contact> {

    public void removeByName(String value) {
        this.removeIf(new Predicate<Contact>() {
            @Override
            public boolean test(Contact x) {
                return value.equalsIgnoreCase(x.getPerson());
            }
        });
    }

    public T searchByName(String value) {
        T contact = null;
        for (Contact element : this) {
            T item = (T) element;
            if (value.equalsIgnoreCase(item.getPerson())) {
                contact = item;
                break;
            }
        }
        return contact;
    }

    public PhoneBook<T> sortByParam(String param) {
        PhoneBook<T> book = this;
        book.sort(new ContactComparator(param));
        return book;
    }
}
