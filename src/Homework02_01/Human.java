package Homework02_01;

public class Human implements Member{
    private String name;
    private int jumpHeight;
    private int runLength;

    public Human(String name, int jumpHeight, int runLength){
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;

    }

    @Override
    public int run() {
        System.out.println("Человек " + name + " пробежал дистанцию " + runLength);
        return runLength;
    }

    @Override
    public int jump() {
        System.out.println("Человек " + name + " пыгнул на " + jumpHeight + " метров");
        return jumpHeight;
    }

    @Override
    public String toString() {
        return "Человек " +
                "Имя = " + name + "|" +
                "Высота прыжка: " + jumpHeight +
                "Скорость бега: " + runLength;
    }

}
