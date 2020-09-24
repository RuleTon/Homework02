package Homework02_01;

public class Tournament {

    private Inter[] inters;
    private Member[] members;

    private String tournamets;

    public Tournament(String tournamets) {
        this.tournamets = tournamets;
    }

    public void setInters (Inter... inters){
        this.inters = inters;
    }

    public void setMembers (Member... members) {
        this.members = members;
    }

    public void startTournament() {
        System.out.println("____________________________________________");

        for (Member member: members) {
            boolean success = passAll(member);
            if (!success) {
                System.out.println("Участник " + member + " выбыл");
            }
            else {
                System.out.println("Участник " + " смог пройти");
            }
        }

    }
    private boolean passAll (Member member) {
        for (Inter inter: inters) {
            if (!inter.passObstacleBy(member) ) {
                return false;
            }
        }
        return true;
    }



}
