package com.pb.vynohradova_oksana.hw7;

public class Atelier {
    public static void main(String[] args) {
        Clothes[] clothes = {new Pants(Size.XXS, 35.99, "Синий"),
                            new Skirt(Size.S, 31.59, "Зеленый"),
                            new Tie(Size.L,25.00, "Серый"),
                            new Tshirt(Size.M, 19.99, "Красный"),
                            new Tshirt(Size.XXS, 14.49, "Желтый"),
                            new Pants(Size.XS, 39.99, "Черный")
        };

        System.out.println("В наличии мужская одежда:");
        dressMan(clothes);
        System.out.println(System.lineSeparator()
                            + "В наличии женская одежда:");
        dressWomen(clothes);
    }

    private static void dressMan(Clothes[] clothes) {
        for (Clothes c:clothes) {
            if (c instanceof ManClothes) {
                ((ManClothes) c).dressMan();
            }
        }
    }

    private static void dressWomen(Clothes[] clothes) {
        for (Clothes c:clothes) {
            if (c instanceof WomenClothes) {
                ((WomenClothes) c).dressWomen();
            }
        }
    }
}
