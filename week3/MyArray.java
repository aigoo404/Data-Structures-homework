package week3;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

//Task 1.1: Linear search
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length + 1; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public int recursiveLinearSearch(int target) {
		return linearSearch(target, 0);
	}

	private int linearSearch(int target, int index) {
		if (index > array.length) {
			return -1;
		} else if (array[index] == target) {
			return index;
		}
		return linearSearch(target, index + 1);
	}

//Task 1.2: Binary search
	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				low = mid + 1;
			} else
				high = mid - 1;
		}
		return -1;
	}

	public int recursiveBinarySearch(int target) {
		return binarySearch(0, array.length - 1, target);
	}

	private int binarySearch(int low, int high, int target) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			if (array[mid] == target) {
				return mid;
			}
			if (array[mid] > target) {
				return binarySearch(low, mid - 1, target);
			}
			return binarySearch(mid + 1, high, target);
		}
		return -1;
	}

//Task 1.3: implement for array with descending order 
	public int reverseSort(int target) {
		int low = 0;
		int high = array.length - 1;
		for (int i = high; i >= low; i--) {
			int mid = low + (high - low) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				low = mid + 1;
			} else
				high = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int[] revarr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		MyArray arr1 = new MyArray(arr);
		MyArray arr2 = new MyArray(revarr);
		int r1 = arr1.iterativeLinearSearch(45);
		int r2 = arr1.recursiveLinearSearch(45);
		int r3 = arr1.iterativeBinarySearch(45);
		int r4 = arr1.recursiveBinarySearch(45);
		int r5 = arr2.reverseSort(5);
		System.out.println("By Iterative Linear Search, found at index: " + r1);
		System.out.println("By Recursive Linear Search, found at index: " + r2);
		System.out.println("By Iterative Binary Search, found at index: " + r3);
		System.out.println("By Recursive Binary Search, found at index: " + r4);
		System.out.println("From reverse array, found at index: " + r5);
	}
}