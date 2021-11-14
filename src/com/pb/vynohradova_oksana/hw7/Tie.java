package com.pb.vynohradova_oksana.hw7;

public class Tie extends Clothes implements ManClothes {
    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println(System.lineSeparator()
                + "Галстук" + System.lineSeparator()
                + size.getDescription() + ": Евро " + size.getEuroSize()
                + ", амер. " + size + System.lineSeparator()
                + "Цвет: " + color + System.lineSeparator()
                + "Цена: " + price + "$");
    }
}
