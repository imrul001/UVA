package uva401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.Begin();
	}

	void Begin() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		while ((line = reader.readLine()) != null) {
			boolean regularPalindrome = isRegularPalindrome(line);
			boolean iregularPalindrome = isIregularPalindrome(line);
			print(line, regularPalindrome, iregularPalindrome);
		}

	}

	boolean isRegularPalindrome(String line) {
		boolean flag = true;
		int length = line.length();
		int limit = ((length % 2 == 0) ? (length / 2) : ((length / 2) + 1));
		for (int i = 0; i < limit; i++) {
			if (line.charAt(i) != line.charAt((length - 1) - i)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	boolean isIregularPalindrome(String line) {
		boolean flag = true;
		int length = line.length();
		int limit = ((length % 2 == 0) ? (length / 2) : ((length / 2) + 1));
		for (int i = 0; i < limit; i++) {
			if (line.charAt(i) != getReversedCharacter(line.charAt((length - 1)
					- i))) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	boolean isOwnReverseMirrored(String line) {
		char otherReversed[] = { 'E', 'J', 'L', 'S', 'Z', '2', '3', '5' };
		return booleanBychecking(line, otherReversed);
	}

	boolean booleanBychecking(String line, char arr[]) {
		boolean flag = true;
		for (int i = 0; i < line.length(); i++) {
			String q = String.valueOf(line.charAt(i));
			if (new String(arr).contains(q)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	void print(String line, boolean regularPalindrome,
			boolean iregularPalindrome) {
		boolean ownReveresd = isOwnReverseMirrored(line);
		if (regularPalindrome) {
			if (ownReveresd && iregularPalindrome) {
				System.out.println(line + " -- is a mirrored palindrome.");
			} else {
				System.out.println(line + " -- is a regular palindrome.");
			}
		} else {
			if (iregularPalindrome && !ownReveresd) {
				System.out.println(line + " -- is a mirrored string.");
			} else {
				System.out.println(line + " -- is not a palindrome.");
			}
		}
		System.out.println();
	}

	char getReversedCharacter(char ch) {
		char a[] = new char[128];
		a['A'] = 'A';
		a['E'] = '3';
		a['H'] = 'H';
		a['I'] = 'I';
		a['J'] = 'L';
		a['L'] = 'J';
		a['M'] = 'M';
		a['O'] = 'O';
		a['S'] = '2';
		a['T'] = 'T';
		a['U'] = 'U';
		a['V'] = 'V';
		a['W'] = 'W';
		a['X'] = 'X';
		a['Y'] = 'Y';
		a['Z'] = '5';
		a['1'] = '1';
		a['2'] = 'S';
		a['3'] = 'E';
		a['5'] = 'Z';
		a['8'] = '8';
		return a[ch];
	}
}
