package geekbrain;

public class Homework02_01 {

    public static void main(String[] args) {
        int [] a =  {1,1,0,0,1,0,1,1,0,0};

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) a[i] = a[i] + 1;
            else a[i] = a[i] - 1;
            System.out.println(a[i]);
        }


    }
}
