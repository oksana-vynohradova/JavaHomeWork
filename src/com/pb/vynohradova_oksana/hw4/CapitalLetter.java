package com.pb.vynohradova_oksana.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);
        System.out.println("Введите текст и я покажу Вам фокус)");
        String text = q.nextLine();
        if (text.isEmpty()) {
            System.out.println("С пустой строкой магия не работает");
        } else {
            text = makeFirstLetterBig(text);

            System.out.println("Магия..." + System.lineSeparator()
                    + text);
        }
    }

    static String makeFirstLetterBig (String str){
        StringBuilder sb = new StringBuilder(str);
        sb.replace(0, 1, str.substring(0,1).toUpperCase());

        for (int i = 0; i < sb.length(); i++) {
            int space = sb.indexOf(" ", i);
            if (space != -1) {
                sb.replace(space + 1, space + 2, sb.substring(space + 1, space + 2).toUpperCase());
                i = space;
            } else break;
        }

        return sb.toString();
    }
}
