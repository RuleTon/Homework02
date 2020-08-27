package Homework03;

import java.util.Scanner;
import java.lang.Math;

public class Homework03_01 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        playLevel();

    }


    private static void playLevel() {
        int nTry, ranNum = (int) (Math.random() * 10);
        System.out.println("Введите число от 0 до 9.Дается 3 попытки");

        for (int i = 0; i < 3; i++)
        {
            System.out.println("Попытка " + (i + 1) + " - ");
            nTry = scanner.nextInt();
            if (nTry < ranNum) System.out.println("Мало");
            if (nTry > ranNum) System.out.println("Много");
            if (nTry == ranNum) System.out.println("Число угадано");
        }
            System.out.println("Хотите снова сыграть в игру? 1 - Да / 2 - Нет");
            nTry = scanner.nextInt();
            if (nTry == 1) playLevel();
            else System.out.println("Завершение игры");

                }
            }






