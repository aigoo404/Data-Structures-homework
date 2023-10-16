package week4;

import java.util.Arrays;

public class Task1 {
    // Task 1.1
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] < arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            print(i, arr);
        }
    }

    // Task 1.2
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] < arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
            print(i, arr);
        }
    }

    // Task 1.3
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp > arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
            print(i, arr);
        }

    }

    // Use for printing each cycles
    public static void print(int count, int[] arr) {
        System.out.printf("Cycles " + count + ": ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[" + arr[i] + "]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 14, 18, 8, 2, 17, 11, 19 };
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        // selectionSort(arr);
        // bubbleSort(arr);
        insertionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
