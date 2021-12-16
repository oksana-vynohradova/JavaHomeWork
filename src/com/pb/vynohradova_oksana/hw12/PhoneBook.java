package com.pb.vynohradova_oksana.hw12;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneBook<T extends Contact> extends ArrayList<T> {

    public void removeByName(String value) {
        this.removeIf(x -> value.equalsIgnoreCase(x.getPerson())); //Predicate<Contact>
    }

    public T searchByName(String value) {
        Stream<T> contactsStream = this.stream();
        return contactsStream.filter(elem -> value.equalsIgnoreCase(elem.getPerson()))
                .findFirst().orElse(null);
    }

    public PhoneBook<T> sortByParam(String param) {
        Stream<T> contactsStream = this.stream();
        return contactsStream.sorted(new ContactComparator(param))
                .collect(Collectors.toCollection(PhoneBook::new));
    }
}
