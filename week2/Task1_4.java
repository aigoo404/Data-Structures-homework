package week2;

public class Task1_4 {
	public static void towerOfHn(int disk, char source, char spare, char destination) {
		if (disk == 1) {
			System.out.println("Disk 1 moved from " + source + " to " + destination);
			return;
		}
		towerOfHn(disk - 1, source, destination, spare);
		System.out.println("Disk " + disk + " moved from " + source + " to " + destination);
		towerOfHn(disk - 1, spare, source, destination);
	}

	public static void main(String[] args) {
		towerOfHn(4, 'A', 'B', 'C');
	}
}
