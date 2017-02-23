package uva458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author imrul
 * 
 */
class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.Begin();
	}

	void Begin() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String str;
		while ((str = reader.readLine()) != null) {
			for (char ch : str.toCharArray()) {
				Decode(ch);
			}
			System.out.println();
		}

	}

	void Decode(char ch) {
		System.out.print((char) (ch - 7));
	}
}