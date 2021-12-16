package com.pb.vynohradova_oksana.hw12;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {
    private final String param;

    public ContactComparator(String param) {
        this.param = param;
    }
    @Override
    public int compare(Contact c1, Contact c2) {
        switch (param) {
            case "address":
                if (c1.getAddress() == null && c2.getAddress() == null) {
                    return 0;
                } else if (c1.getAddress() == null) {
                    return 1;
                } else if (c2.getAddress() == null) {
                    return -1;
                } else {
                    return c1.getAddress().compareTo(c2.getAddress());
                }
            case "birth":
                if (c1.getDateOfBirth() == null && c2.getDateOfBirth() == null) {
                    return 0;
                } else if (c1.getDateOfBirth() == null) {
                    return 1;
                } else if (c2.getDateOfBirth() == null) {
                    return -1;
                } else {
                    return c1.getDateOfBirth().compareTo(c2.getDateOfBirth());
                }
            case "editing":
                if (c1.getEditing() == null && c2.getEditing() == null) {
                    return 0;
                } else if (c1.getEditing() == null) {
                    return 1;
                } else if (c2.getEditing() == null) {
                    return -1;
                } else {
                    return c1.getEditing().compareTo(c2.getEditing());
                }
            case "nameignorecase":
                return c1.getPerson().toLowerCase().compareTo(c2.getPerson().toLowerCase());
            default:
                return c1.getPerson().compareTo(c2.getPerson());
        }
    }
}
