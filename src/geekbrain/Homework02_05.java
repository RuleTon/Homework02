package geekbrain;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

public class Homework02_05 {

    public static void main(String[] args) {



        int [] a = {1,2,3,4,6,9,0};
        int min =  a[0];
        int max = a[0];


        for (int i = 0; i <= 6; i++) {


            if (a[i] < min) min = a[i];

            if (a[i] > max) max = a[i];
        }

            System.out.println("Small" + min);
            System.out.println("Large" + max);



        }
    }


