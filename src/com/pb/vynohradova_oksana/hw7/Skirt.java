package com.pb.vynohradova_oksana.hw7;

public class Skirt extends Clothes implements WomenClothes {
    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWomen() {
        System.out.println(System.lineSeparator()
                + "Юбка" + System.lineSeparator()
                + size.getDescription() + ": Евро " + size.getEuroSize()
                + ", амер. " + size + System.lineSeparator()
                + "Цвет: " + color + System.lineSeparator()
                + "Цена: " + price + "$");
    }
}
