package geekbrain;

public class Homework02_04 {
    public static void main(String[] args) {

        int [][] a = new int[4][4];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0, b = a[i].length - 1; j < a[i].length ; j ++, b--) {
                if (i == j || i == b) a[i][j] = 1;
                else a[i][j] = 0;
                System.out.print(a[i][j] + " ");

            }
            System.out.print("\n");
        }

    }
}
