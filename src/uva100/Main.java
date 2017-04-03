package uva100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "/home/linux/tutorial/UVA/src/uva100/input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		while ((line = reader.readLine()) != null) {
			StringBuffer start = new StringBuffer();
			StringBuffer end = new StringBuffer();
			int i = 0, j = 0;
			int flag = 0;
			for (int index = 0; index < line.length(); index++) {
				if (flag != 1) {
					if (line.charAt(index) == ' ') {
						flag = 1;
						i = Integer.valueOf(start.toString());
					} else {
						start.append(line.charAt(index));
					}
				} else {
					if (line.charAt(index) != ' ') {
						end.append(line.charAt(index));
					}
					if (index == line.length() - 1) {
						j = Integer.valueOf(end.toString());
					}
				}
			}
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

	private int getCycle(int input) {
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
