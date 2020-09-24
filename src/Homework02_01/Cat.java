package Homework02_01;

public class Cat implements Member {
    private String name;
    private int jumpHeight;
    private int runLength;

    public Cat(String name, int jumpHeight, int runLength){
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;

    }

    @Override
    public int run() {
        System.out.println("Кот " + name + " пробежал дистанцию " + runLength);
        return runLength;
    }

    @Override
    public int jump() {
        System.out.println("Кот " + name + " пыгнул на " + jumpHeight + "метров");
        return jumpHeight;
    }

    @Override
    public String toString() {
        return "Кот " +
                "Имя = " + name + "|" +
                "Высота прыжка" + jumpHeight +
                "Скорость бега" + runLength;
    }

}
