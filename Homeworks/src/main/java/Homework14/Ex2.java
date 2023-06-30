package Homework14;

public class Ex2 {

    private static int biggestValue(int[][] matrix) {
        int biggestValue = matrix[0][0];
        for (int[] rows : matrix) {
            for (int column : rows) {
                if (column > biggestValue) {
                    biggestValue = column;
                }
            }
        }
        return biggestValue;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 9, 6}, {7, 8, 5}};
        System.out.println(biggestValue(matrix));
    }
}
