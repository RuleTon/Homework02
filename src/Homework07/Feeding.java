package Homework07;

import java.util.Scanner;


public class Feeding {
    private static Scanner scanner = new Scanner(System.in);

    public static class Plate {
        private int food;



        public Plate(int food) {
            this.food = food;

        }

        public void decreaseFood(int n) {
            food -= n;
        }

        public void info() {
            System.out.println("Еды в тарелке: " + food);


        }
        public void check() {
            if (food <= 0) {
                System.out.println("Миска пуста, необходимо положить еды ");
                food = scanner.nextInt();
                System.out.println("Количетсво еды теперь равняется " + food);



            }
        }
    }

    public static class Cat {
        private String name;
        private int appetite;
        private int hungryLevel;
        public Cat(String name, int appetite, int hungryLevel) {
            this.name = name;
            this.appetite = appetite;
            this.hungryLevel = hungryLevel;
        }
        public void eat(Plate p) {
            p.decreaseFood(appetite);
            hungryLevel += appetite;

        }

    }
    public static class MainClass {
        public static void main(String[] args) {


            Cat cat0 = new Cat ("Барсик", 15, 0);
            Cat cat1 = new Cat ("Томас", 5, 0);
            Cat cat2 = new Cat ("X12rus", 4, 0);
            Plate plate = new Plate(15);
            plate.info();
            plate.check();

            cat0.eat(plate);
            System.out.println("Сытость кота: "+ cat0.name + " составляет " + cat0.hungryLevel);
            plate.info();
            plate.check();

            cat1.eat(plate);
            System.out.println("Сытость кота: "+ cat1.name + " составляет " + cat1.hungryLevel);
            plate.info();
            plate.check();

            cat2.eat(plate);
            System.out.println("Сытость кота: "+ cat2.name + " составляет " + cat2.hungryLevel);
            plate.info();





        }


    }

}
