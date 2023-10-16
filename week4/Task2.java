package week4;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    // Task 2.1
    public static int[] merge(int[] left, int[] right) {
        int[] sorted = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                sorted[k] = left[i];
                k++;
                i++;
            } else {
                sorted[k] = right[j];
                k++;
                j++;
            }
        }
        if (i == left.length) {
            while (j < right.length) {
                sorted[k] = right[j];
                j++;
                k++;
            }
        }
        if (j == right.length) {
            while (i < left.length) {
                sorted[k] = left[i];
                k++;
                i++;
            }
        }
        return sorted;
    }

    public static int[] mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            int[] stop = new int[1];
            stop[0] = arr[left];
            return stop;
        }
        int mid = (left + right) / 2;
        int[] leftHalf = mergeSort(arr, left, mid);
        int[] rightHalf = mergeSort(arr, mid + 1, right);
        int[] merged = merge(leftHalf, rightHalf);
        return merged;
    }

    // Task 2.2
    public static int getPivot_Last(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static int getPivot_First(int arr[], int low, int high) {
        int pivot = arr[low];
        int k = high;
        for (int i = high; i > low; i--) {
            if (arr[i] > pivot) {
                swap(arr, i, k);
                k--;
            }
            swap(arr, low, k);

        }
        return k;
    }

    public static void random(int arr[], int low, int high) {
        Random rd = new Random();
        int pivot = rd.nextInt(high - low) + low;
        swap(arr, high, pivot);
    }

    public static int getPivot_Random(int[] arr, int low, int high) {
        random(arr, low, high);
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void quickSort_FirstPivot(int arr[], int low, int high) {
        if (low < high) {
            int pivot = getPivot_First(arr, low, high);
            quickSort_FirstPivot(arr, low, pivot - 1);
            quickSort_FirstPivot(arr, pivot + 1, high);
        }
    }

    public static void quickSort_LastPivot(int arr[], int low, int high) {
        if (low < high) {
            int pivot = getPivot_Last(arr, low, high);
            quickSort_LastPivot(arr, low, pivot - 1);
            quickSort_LastPivot(arr, pivot + 1, high);
        }
    }

    public static void quickSort_RandomPivot(int arr[], int low, int high) {
        if (low < high) {
            int pivot = getPivot_Random(arr, low, high);
            quickSort_RandomPivot(arr, low, pivot - 1);
            quickSort_RandomPivot(arr, pivot + 1, high);
        }
    }

    // Use to swap element
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int[] arr2 = { 10, 7, 8, 9, 1, 5 };
        int[] arr3 = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        // int[] mergedArr = mergeSort(arr, 0, arr.length - 1);
        // System.out.println("Sorted Array: " + Arrays.toString(mergedArr));
        quickSort_FirstPivot(arr, 0, arr.length - 1);
        quickSort_LastPivot(arr2, 0, arr2.length - 1);
        quickSort_RandomPivot(arr3, 0, arr3.length - 1);
        System.out.println("Quick sort by using first element as pivot: " + Arrays.toString(arr));
        System.out.println("Quick sort by using last element as pivot: " + Arrays.toString(arr2));
        System.out.println("Quick sort by using random element as pivot: " + Arrays.toString(arr3));
    }
}