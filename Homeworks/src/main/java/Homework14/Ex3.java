package Homework14;

public class Ex3 {
    public static void main(String[] args) {
        int[][] array = {
                {31, 21, 3},
                {41, 50, 6},
                {70, 89, 9}
        };
        int sumOnMainDiagonal = 0;
        for (int i = 0; i < array.length; i++) {
            sumOnMainDiagonal += array[i][i];
        }
        System.out.println("The sum of the elements on the main diagonal is: " + sumOnMainDiagonal);
    }
}
