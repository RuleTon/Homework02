package Homework02_02;

public class MyArrayDataException extends Exception
{
    public int i;
    public int j;

    MyArrayDataException(int i, int j) {
        this.i = i+1;
        this.j = j+1;

    }

}
