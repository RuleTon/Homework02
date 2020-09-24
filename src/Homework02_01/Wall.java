package Homework02_01;

public class Wall implements Inter {
    private int height;

    public Wall(int height) {
        this.height = height;

    }


    @Override
    public boolean passObstacleBy(Member member) {
        if (member.jump() > height) {
            System.out.println(member + "успешно прыгнул");
            return true;
        }
        else {
            System.out.println(member + "не смог перепрыгнуть");
            return false;
        }
    }


}
