package uva10193;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	private void begin() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"F:\\imrul\\workspace\\UVA\\src\\uva10193\\input.txt"));
		// BufferedReader reader = new BufferedReader(new InputStreamReader(
		// System.in));
		int testCases = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= testCases; i++) {
			String s1 = reader.readLine();
			String s2 = reader.readLine();
			solve(s1, s2, i);
		}
		System.exit(0);
	}

	private static void solve(String s1, String s2, int pair) {
		int num1 = getInt(s1);
		int num2 = getInt(s2);
		boolean isLove = false;

		int limit = num1 > num2 ? num2 : num1;
		for (int i = limit; i >= 2; i--) {
			if ((num1 % i == 0)) {
				if ((num2 % i == 0)) {
					System.out.println("divisor " + i);
					isLove = true;
					break;
				}
			}
		}
		if (isLove) {
			System.out.println("Pair #" + pair + ": All you need is love!");
		} else {
			System.out.println("Pair #" + pair + ": Love is not all you need!");
		}
	}

	static int getInt(String str) {
		int integer = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '0') {
				integer += Math.pow(2, (str.length() - (i + 1)));
			}
		}
		return integer;
	}

	public static boolean isPrime(long n) {
		// fast even test.
		if (n > 2 && (n & 1) == 0)
			return false;
		// only odd factors need to be tested up to n^0.5
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}
}
