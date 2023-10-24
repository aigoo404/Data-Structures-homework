package week5;

import java.util.Arrays;

public class Task1 {
    // Task 1.1
    public static int[][] add(int[][] a, int[][] b) {
        int rows = a.length;
        int columns = a[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    // Task 1.2
    public static int[][] subtract(int[][] a, int[][] b) {
        int rows = a.length;
        int columns = a[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    // Task 1.3
    public static int[][] multiply(int[][] a, int[][] b) {
        int rowA = a.length;
        int rowB = b.length;
        int columnB = b[0].length;
        int[][] result = new int[rowA][columnB];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < columnB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < rowB; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // Task 1.4
    public static int[][] transpose(int[][] a) {
        int row = a.length;
        int column = a[0].length;
        int[][] result = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[j][i] = a[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] b = { { 3, 4, 5 }, { 6, 7, 8 } };
        int[][] addArray = add(a, b);
        int[][] subArray = subtract(a, b);
        int[][] mulArray = multiply(a, b);
        int[][] transArr = transpose(a);
        System.out.println("Added Array: " + Arrays.deepToString(addArray));
        System.out.println("Subtracted Array: " + Arrays.deepToString(subArray));
        System.out.println("Multiplied Array: " + Arrays.deepToString(mulArray));
        System.out.println("Transposed Array: " + Arrays.deepToString(transArr));
    }
}
