package uva100;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "/home/linux/tutorial/UVA/src/uva100/input.txt"));
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = i;
			int y = j;
			if (x > y) {
				int temp = y;
				y = x;
				x = temp;
			}
			int max = 0;
			for (int k = x; k <= y; k++) {
				int cycle = getCycle(k);
				if (cycle > max) {
					max = cycle;
				}
			}
			System.out.println(i + " " + j + " " + max);
		}
	}

	int getCycle(long input) {
		int cycleCount = 1;
		while (input != 1) {
			if (input % 2 == 0) {
				input = input / 2;
			} else {
				input = (3 * input) + 1;
			}
			cycleCount++;
		}
		return cycleCount;
	}
}
