package com.pb.vynohradova_oksana.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        pantsInfo("мужские");
    }

    @Override
    public void dressWomen() {
        pantsInfo("женские");
    }

    private void pantsInfo(String gender) {
        System.out.println(System.lineSeparator()
                + "Брюки " + gender + System.lineSeparator()
                + size.getDescription() + ": Евро " + size.getEuroSize()
                + ", амер. " + size + System.lineSeparator()
                + "Цвет: " + color + System.lineSeparator()
                + "Цена: " + price + "$");
    }
}
