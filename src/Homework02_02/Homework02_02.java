package Homework02_02;

public class Homework02_02 {
    public static void main(String[] args) {

        String [][] arr = new String[][]{{"1", "2", "3", "4"}, {"4", "5", "2", "1"}, {"1", "1", "3", "2"}, {"2", "2", "4", "2"}};
        try {
                int result = method(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива превышен!");
        }

        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива!");
            System.out.println("Ошибка находится в ячейке: " + "y: " + e.i + "; x: " + e.j);
        }

    }


    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(String.valueOf(arr[i][j]));
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }
}
