package Homework02_01;

import java.util.Random;

public class Homework02_01 {

    public static void main(String[] args) {
        Member[] members;
        System.out.println("______________________________________________");
        Member human = new Human("Стас", 60,600);
        Member cat = new Cat("Томас", 300, 1000);
        Member robot = new Robot("Clutch", 200, 5000);


        Wall wall = new Wall(10);
        Track track = new Track(100);

        Tournament tournament = new Tournament("Arena");
        tournament.setMembers(human,cat,robot);
        tournament.setInters(wall,track);

        tournament.startTournament();




        }




    }

