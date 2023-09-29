package week1;

import java.util.Arrays;

public class MyArray {
	public MyArray(int[] array) {
	}

	// Method mirror that outputs the contents of an array in a reverse order like a
	// mirror
	// Input: [1, 2, 3]
	// Output: [1, 2, 3, 3, 2, 1]

	public int[] mirror(int[] inputArr) {
		int n = inputArr.length;
		int[] mirroredArr = new int[n * 2];
		for (int i = 0; i < n; i++) {
			mirroredArr[i] = inputArr[i];
			mirroredArr[n * 2 - i - 1] = inputArr[i];
		}
		return mirroredArr;
	}

	// removes all duplicate elements from an array and returns a new array
	// Input: 1 3 5 1 3 7 9 8
	// Output: 1 3 5 7 9 8

	public int[] removesDuplicates(int[] inputArr) {
		int[] duplicatedArr = new int[inputArr.length];
		int index = 0;
		for (int i = 0; i < inputArr.length; i++) {
			boolean isDuplicate = false;
			for (int j = 0; j < index; j++) {
				if (inputArr[i] == duplicatedArr[j]) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				duplicatedArr[index++] = inputArr[i];
			}
		}
		int[] result = new int[index];
		System.arraycopy(duplicatedArr, 0, result, 0, index);
		return result;
	}

	// Input: 10 11 12 13 14 16 17 19 20
	// Output: 15 18
	public static int[] getMissingValues(int[] inputArr) {
		int[] result = new int[inputArr.length];
		int index = 0;
		for (int i = 0; i < inputArr.length - 1; i++) {
			if (inputArr[i + 1] - inputArr[i] > 1) {
				for (int j = inputArr[i] + 1; j < inputArr[i + 1]; j++) {
					result[index++] = j;
				}
			}
		}
		// copy the result array to the final result array using for loop
		int[] finalResult = new int[index];
		for (int i = 0; i < index; i++) {
			finalResult[i] = result[i];
		}
		return finalResult;
	}

	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 16 17 19 20
	public static int[] fillingMissingValues(int[] inputArr, int k) {
		if (k <= 0 || k >= inputArr.length) {
			throw new IllegalArgumentException("K must be greater than 0 and less than the length of the array");
		}
		int[] result = new int[inputArr.length];
		for (int i = 0; i < inputArr.length; i++) {
			result[i] = inputArr[i];
		}

		for (int i = 0; i < inputArr.length; i++) {
			if (inputArr[i] == -1) {
				if (i == 0) {
					result[i] = inputArr[i + 1];
					break;
				} else if (i == inputArr.length - 1) {
					result[i] = inputArr[i - 1];
					break;
				} else {
					int sum = 0;
					int count = 0;
					for (int j = i - k; j <= i + k; j++) {
						if (j >= 0 && j < inputArr.length && inputArr[j] != -1) {
							sum += inputArr[j];
							count++;
						}
					}
					result[i] = sum / count;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4 };
		MyArray arr2 = new MyArray(arr1);
		System.out.println("Mirrored Array: " + Arrays.toString(arr2.mirror(arr1)));
		int[] arr3 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		MyArray arr4 = new MyArray(arr3);
		System.out.println("Removed Duplicates Array: " + Arrays.toString(arr4.removesDuplicates(arr3)));
		int[] missingArr = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		int[] missingValues = getMissingValues(missingArr);
		System.out.println("Missing Value: " + Arrays.toString(missingValues));
		int[] missingValueArr = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };
		int[] expectArr = fillingMissingValues(missingValueArr, 3);
		System.out.println("Filled Missing Value Array: " + Arrays.toString(expectArr));
	}
}
