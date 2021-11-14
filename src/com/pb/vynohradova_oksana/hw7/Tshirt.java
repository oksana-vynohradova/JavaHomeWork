package com.pb.vynohradova_oksana.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {
    public Tshirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        tshirtInfo("мужская");
    }

    @Override
    public void dressWomen() {
        tshirtInfo("женская");
    }

    private void tshirtInfo(String gender) {
        System.out.println(System.lineSeparator()
                + "Футболка " + gender + System.lineSeparator()
                + size.getDescription() + ": Евро " + size.getEuroSize()
                + ", амер. " + size + System.lineSeparator()
                + "Цвет: " + color + System.lineSeparator()
                + "Цена: " + price + "$");
    }
}
