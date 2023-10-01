package week2;

public class Task1_3 {
	public static void print(int row) {
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < row - i; j++) {
				System.out.print(" ");
			}
			int[] currentRow = getPascalTriangle(i);
			for (int num : currentRow) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	public static int[] getPascalTriangle(int n) {
		if (n == 1) {
			return new int[0];
		}
		int[] prev = getPascalTriangle(n - 1);
		return generateNextRow(prev);
	}

	public static int[] generateNextRow(int[] prevRow) {
		int[] nextRow = new int[prevRow.length + 1];
		nextRow[0] = 1;
		nextRow[nextRow.length - 1] = 1;
		for (int i = 1; i < nextRow.length - 1; i++) {
			nextRow[i] = prevRow[i - 1] + prevRow[i];
		}
		return nextRow;
	}

	public static void main(String[] args) {
		print(10);
	}
}
