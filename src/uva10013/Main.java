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
		// "F:\\imrul\\workspace\\UVA\\src\\uva10013\\input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;

		while ((line = reader.readLine()) != null) {
			int testCases = Integer.parseInt(line);
			for (int i = 0; i < testCases; i++) {
				reader.readLine();
				int digits = Integer.parseInt(reader.readLine());
				int[] number1 = new int[digits];
				int[] number2 = new int[digits];
				int[] number3 = new int[digits];
				for (int j = 0; j < digits; j++) {
					String[] num1_num2 = reader.readLine().split(" ");
					number1[j] = Integer.parseInt(num1_num2[0]);
					number2[j] = Integer.parseInt(num1_num2[1]);
				}
				int carry = 0;
				for (int k = digits - 1; k >= 0; k--) {
					int temp = number1[k] + number2[k] + carry;
					if (temp < 10) {
						number3[k] = temp;
						carry = 0;
					}
					if (temp > 10) {
						number3[k] = temp % 10;
						carry = 1;
					}
				}
				if (carry == 1) {
					System.out.print(carry);
				}
				for (int k = 0; k <= digits - 1; k++) {
					System.out.print(number3[k]);
				}
				System.out.println();
				if (testCases > 0) {
					System.out.println();
				}
			}
		}
	}
}
