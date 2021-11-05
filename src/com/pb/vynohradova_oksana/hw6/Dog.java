package com.pb.vynohradova_oksana.hw6;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class Dog extends Animal{
    private final String[] commands = {"сидеть", "играть", "голос"};

    public Dog() {
        super();
        kind = "собака";
    }

    public Dog(String name, String food, String location) {
        super(name, food, location);
        kind = "собака";
    }

    @Override
    public void makeNoise() {
        System.out.println(getName() + " говорит Вам: \"Гав-Гав\"");
    }

    @Override
    public void eat(String food) {
        if (isHungry) {
            if (notNullOrEmpty(food) && food.equalsIgnoreCase("косточка")) {
                    System.out.println(getName() + " с аппетитом ест " + food);
                    isHungry = false;
                } else if (notNullOrEmpty(food) && !food.equalsIgnoreCase("косточка")){
                    System.out.println(food + " ешьте сами. Собачка хочет косточку");
                } else super.eat();
            }
        }

    public void command(String action) {
        String act = "";
        for (String a:commands) {
            if (action.toLowerCase().equals(a)) {
               act = a;
            }
        }
        switch (act) {
            case "сидеть":
                System.out.println(getName() + " сидит. Хорошая собачка.");
                break;
            case "играть":
                System.out.println(getName() + " бегает за своим хвостом.");
                break;
            case "голос":
                this.makeNoise();
                break;
            default:
                System.out.println(getName() + " не знает такой команды.");
        }
        isHungry = true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " extends " + getClass().getSuperclass().getSimpleName() +
                "{name='" + getName() + '\'' +
                ", food='" + getFood() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", commands=" + Arrays.toString(commands) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return getName().equals(dog.getName())
                && getFood().equals(dog.getFood())
                && getLocation().equals(dog.getLocation());
                //&& Arrays.equals(commands, dog.commands);
                //вероятно, можно не проверять то, что final? C точки зрения логики.
                // Уточнить
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFood(), getLocation()) + Arrays.hashCode(commands);
    }
}
