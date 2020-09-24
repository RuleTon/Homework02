package Homework02_01;

public class Track implements  Inter{

    private int length;

    public Track(int length) {
        this.length = length;

    }


    @Override
    public boolean passObstacleBy(Member member) {
        if (member.run() > length) {
            System.out.println(member + "успешно пробежал");
            return true;
        }
        else {
            System.out.println(member + "не смог пробежать");
            return false;
        }
    }
}
