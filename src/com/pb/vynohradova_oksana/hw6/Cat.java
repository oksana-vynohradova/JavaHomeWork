package com.pb.vynohradova_oksana.hw6;

import java.util.Arrays;
import java.util.Objects;

public class Cat extends Animal{
    private String toy;

    public Cat() {
        super();
        kind = "кот";
    }

    public Cat(String name, String food, String location, String toy) {
        super(name, food, location);
        this.toy = toy;
        kind = "кот";
    }

    public void makeNoise() {
        System.out.println(getName() + " говорит Вам: \"Мяу\"");
    }

    public void eat(String food) {
        if (isHungry) {
            if (notNullOrEmpty(food) && food.equalsIgnoreCase("рыбка")) {
                System.out.println(getName() + " с аппетитом ест " + food);
                isHungry = false;
            } else if (notNullOrEmpty(food) && !food.equalsIgnoreCase("рыбка")){
                System.out.println(food + " ешьте сами. Котик хочет рыбки");
            } else super.eat();
        }
    }

    public String getToy() {
        return toy;
    }

    public void setToy(String toy) {
        this.toy = toy;
    }

    public void play() {
        System.out.println(getName() + " нашел(ла) игрушку. Это " + toy + ". (Весело играет)");
        isHungry = true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{name='" + getName() + '\'' +
                ", food='" + getFood() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", toy='" + toy + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return getName().equals(cat.getName())
                && getFood().equals(cat.getFood())
                && getLocation().equals(cat.getLocation())
                && toy.equals(cat.toy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFood(), getLocation(), toy);
    }
}
