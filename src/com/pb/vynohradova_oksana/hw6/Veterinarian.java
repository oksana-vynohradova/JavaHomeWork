package com.pb.vynohradova_oksana.hw6;

public class Veterinarian {
    private String name = "";

    public Veterinarian() {}

    public Veterinarian(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void treatAnimal(Animal animal) {
        System.out.println("Доктор " + name + " принял пациента " + animal.getKind()
                + " по имени " + animal.getName() + ". Карта пациента: ест -  "
                + animal.getFood() + ", место проживания - " + animal.getLocation());
    }
}
