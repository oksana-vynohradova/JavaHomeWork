package com.pb.vynohradova_oksana.hw6;

import java.util.Objects;

public class Horse extends Animal{
    private String rider;

    public Horse() {
        super();
        kind = "лошадь";
    }

    public Horse(String name, String food, String location, String rider) {
        super(name, food, location);
        this.rider = rider;
        kind = "лошадь";
    }

    public void makeNoise() {
        System.out.println("\"И-го-го\" поет лошадка " + getName());
    }

    public void eat(String food) {
        if (isHungry) {
            if (notNullOrEmpty(food) && food.equalsIgnoreCase("морковка")) {
                System.out.println(getName() + " с аппетитом ест " + food);
                isHungry = false;
            } else if (notNullOrEmpty(food) && !food.equalsIgnoreCase("морковка")){
                System.out.println(food + " ешьте сами. Лошадка хочет морковку");
            } else super.eat();
        }
    }

    public String getRider() {
        return rider;
    }

    public void setRider(String rider) {
        this.rider = rider;
    }

    public void ride() {
        System.out.println(rider + " и " + getName() + " отлично покатались.");
        isHungry = true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{name='" + getName() + '\'' +
                ", food='" + getFood() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", rider='" + rider + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return getName().equals(horse.getName())
                && getFood().equals(horse.getFood())
                && getLocation().equals(horse.getLocation())
                && rider.equals(horse.rider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFood(), getLocation(), rider);
    }
}
