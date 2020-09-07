package Homework06;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        this.type = "Кошка";
        this.maxRunSpeed = 200;
        this.maxJumpHeight = 2;

    }

    @Override
    public void swim(int swim) {
        System.out.println("Кошки не могут плавать!");
    }
}
