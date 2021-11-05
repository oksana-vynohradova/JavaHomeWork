package com.pb.vynohradova_oksana.hw6;

public class Animal {
   private String name = "Неизвестное животное";
   private String food;
   private String location = "Где-то";
   protected String kind = "животное";
   protected boolean isHungry = true;

   public Animal() {}

    public Animal(String name, String food, String location) {
       this.name = name;
       this.food = food;
       this.location = location;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
       if (food == null) {
           return "ничего";
       } else {
           return food;
       }
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKind() {
        return kind;
    }

    public void makeNoise() {
        System.out.println(name + " издает какие-то звуки.");
    }

    protected boolean notNullOrEmpty(String str) {
       return (str != null && !str.trim().isEmpty());
    }

    public void eat() {
       if (isHungry) {
         if (notNullOrEmpty(this.food)) {
             System.out.println(name + " с аппетитом ест " + this.food);
             this.food = "";
             isHungry = false;
         } else {
             System.out.println(name + " останется голодным. Нет еды.");
         }
       } else {
           System.out.println(name + " сейчас не хочет есть.");
       }
    }

    public void eat(String food) {
       if (isHungry) {
           if (notNullOrEmpty(food)) {
               System.out.println(name + " с аппетитом ест " + food);
               isHungry = false;
           } else this.eat();
       }
    }

    public void sleep() {
       if (isHungry) {
           System.out.println("А Вы сможете заснуть голодным? Покормите " + name);
       } else {
           System.out.println(name + " сейчас находится в локации \"" + location + "\" и ложится спать");
           isHungry = true;
       }
    }

}
