import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class Calculator {
	public Calculator() {
	}

	// Sum of A n B
	public int intersection(int[] A, int[] B) {
		int result = 0;
		// todo

		for (int b : B) {
			if (IntStream.of(A)
			             .anyMatch(a -> a == b)) {
				result += b;
			}
		}
		return result;
	}

	// Sum of A - B
	public int differenceOfSet(int[] A, int[] B) {
		int result = 0;
		// todo
		for (int b : B) {
			if (IntStream.of(A)
			             .anyMatch(a -> a != b)) {
				result += b;
			}
		}
		return result;
	}
}

class Minesweeper {
	public static int MAP_X = 10;
	public static int MAP_Y = 10;
	private int[][] map;
	private int numOfpick;

	public Minesweeper(int[][] map) {
		this.map = map;
		this.numOfpick = 0;
	}

	public int pick(int x, int y) {
		int numOfMine = 0;
		// todo
		if (map[x][y] >= 1) {
			return -1;
		} else {
			for (int i = x; i < (x + 3); i++) {
				if (i == 0) continue;
				for (int j = y; j < (y + 3); j++) {
					if (j == 0) continue;
					numOfMine += map[i - 1][j - 1];
					if (map[i - 1][j - 1] == 0) {
						map[i - 1][j - 1] = 2;
					}
				}
			}
		}

		return numOfMine;
	}

	public int getNumOfpick() {
		return numOfpick;
	}

	public boolean checkMap() {
		// todo
		for (int i = 0; i < map.length; i++) {
			int[] a = map[i];
			for (int j = 0; j < a.length; j++) {
				if(a[j]!=0); return true;
			}
		}
		return false;
	}

	public void printMap() {
		for (int i = 0; i < MAP_X; i++) {
			for (int j = 0; j < MAP_Y; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}

public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.println("intersection = " + calculator.intersection(new int[]{1, 2, 4, 11, 6, 7, 5, 14, 19, 16}, new int[]{2, 9, 8, 4, 11, 19, 15, 12}));
		System.out.println("differenceOfSet = " + calculator.differenceOfSet(new int[]{1, 2, 4, 11, 6, 7, 5, 14, 19, 16}, new int[]{2, 9, 8, 4, 11, 19, 15, 12}));

		int[][] map = {
				{0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
				{0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
				{0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1, 0, 0, 1, 0, 0},
				{0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
				{0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
				{1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}
		};

		Minesweeper minesweeper = new Minesweeper(map);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Minesweeper start!!!");
		System.out.println("----------------------------------------------------");
		minesweeper.printMap();
		while (!minesweeper.checkMap()) {
			System.out.print("x(0~9) : ");
			int x = scanner.nextInt();
			System.out.print("y(0~9) : ");
			int y = scanner.nextInt();

			if (x >= minesweeper.MAP_X || y >= minesweeper.MAP_Y || x < 0 || y < 0) break;

			int numOfMine = minesweeper.pick(Minesweeper.MAP_Y - y - 1, x);
			if (numOfMine == -1) {
				System.out.println("Mine has exploded!!!");
				break;
			} else {
				System.out.println("There's a mine around : " + numOfMine);
				minesweeper.printMap();
			}
		}

		System.out.println("----------------------------------------------------");
		System.out.println("Number of Attempts : " + minesweeper.getNumOfpick());
		System.out.println("Minesweeper end!!!");
	}
}