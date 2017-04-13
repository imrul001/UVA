package uva10013;

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
		// "/home/linux/tutorial/UVA/src/uva10013/input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		while ((line = reader.readLine()) != null) {
			int testCases = Integer.parseInt(line);
			for (int i = 0; i < testCases; i++) {
				reader.readLine();
				int digits = Integer.parseInt(reader.readLine());
				int[] num1 = new int[digits];
				int[] num2 = new int[digits];
				int[] num3 = new int[digits];
				for (int j = 0; j < digits; j++) {
					String[] temp = reader.readLine().split(" ");
					num1[j] = Integer.valueOf(temp[0]);
					num2[j] = Integer.valueOf(temp[1]);
				}
				int carry = 0;
				StringBuffer sb = new StringBuffer();
				for (int k = digits - 1; k >= 0; k--) {
					num3[k] = num1[k] + num2[k] + carry;
					if (num3[k] >= 10) {
						num3[k] = num3[k] % 10;
						carry = 1;
					} else {
						carry = 0;
					}
					sb.append(num3[k]);
				}
				if (carry == 1) {
					sb.append(carry);
				}
				if (i > 0) {
					System.out.println();
				}
				System.out.println(sb.reverse().toString());
			}
		}

	}
}
