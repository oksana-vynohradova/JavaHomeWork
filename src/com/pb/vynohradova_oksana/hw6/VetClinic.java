package com.pb.vynohradova_oksana.hw6;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class VetClinic {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Animal[] animals = new Animal[4];

        Cat cat = new Cat("Том", "Молоко", "Подоконник", "Бантик");
        animals[0] = cat;
        animals[1] = new Dog("Шарик", "Косточка", "Будка");
        animals[2] = new Horse("Оскар", "Сено", "Стойло", "Первый П.П.");
        animals[3] = new Animal();

        Dog dog = (Dog) animals[1];
        Horse horse = (Horse) animals[2];

        for (Animal a:animals) {
            a.eat("Косточка");
        }

        System.out.println(dog);
        System.out.println(cat);
        System.out.println(horse);

        Class v = Class.forName("com.pb.vynohradova_oksana.hw6.Veterinarian");

        Constructor c = v.getConstructor(String.class);
        Object veterinar = c.newInstance("А.Й. Болит");

        if (veterinar instanceof Veterinarian) {
            for (Animal animal:animals) {
                ((Veterinarian) veterinar).treatAnimal(animal);
            }
        }
    }
}
