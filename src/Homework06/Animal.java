package Homework06;



public class Animal {

    protected String name;
    protected String type;
    protected int maxRunSpeed;
    protected double maxJumpHeight;
    protected int maxSwimDistance;


    public Animal (String name) {
        this.name = name;
    }

    public void speed (int speed) {
        if (this.maxRunSpeed >= speed) System.out.println(this.type + " " + this.name + " бежит " + speed + " метров.");
        else System.out.println(this.type + " " + this.name + " не может так быстро бегать");
    }

    public void jump (double jump) {
        if (this.maxRunSpeed >= jump) System.out.println(this.type + " " + this.name + " прыгает " + jump + " метров.");
        else System.out.println(this.type + " " + this.name + " не может так высоко прыгать");
    }

    public void swim (int swim) {
        if (this.maxRunSpeed >= swim) System.out.println(this.type + " " + this.name + " бежит " + swim + " метров.");
        else System.out.println(this.type + " " + this.name + " не может плавать так далеко");
    }

    public void info () {
        System.out.println(this.type + " " + this.name + " Бежит: " + this.maxRunSpeed + " метров. Прыгает: " + this.maxJumpHeight + " метров. Плавает: " + this.maxSwimDistance + " метров.");
            }


    public static void main(String[] args) {
        Cat cat1 = new Cat("Том");
        Cat cat2 = new Cat("Черныш");

        Dog dog1 = new Dog("Клевер");
        Dog dog2 = new Dog ("Моська");

        cat1.info();
        cat2.info();

        System.out.println();

        dog1.info();
        dog2.info();

        System.out.println();

        cat1.speed(150);
        cat1.jump(1.2);
        cat1.swim(2);

        System.out.println();

        cat2.speed(210);
        cat2.jump(1.7);
        cat2.swim(3);

        System.out.println();

        dog1.speed(150);
        dog1.jump(1.2);
        dog1.swim(2);

        System.out.println();

        dog2.speed(550);
        dog2.jump(0.8);
        dog2.swim(11);
    }







}
