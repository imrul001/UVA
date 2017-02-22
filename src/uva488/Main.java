package uva488;

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
		int testCases = Integer.parseInt(reader.readLine());
		for (int i = 0; i < testCases; i++) {
			reader.readLine();
			int amplitude = Integer.parseInt(reader.readLine());
			int frequency = Integer.parseInt(reader.readLine());
			for (int j = 0; j < frequency; j++) {
				printWave(amplitude);
				if (j < frequency - 1) {
					System.out.println();
				}
			}
			if (i < testCases - 1) {
				System.out.println();
			}
		}
	}

	void printWave(int amplitude) {
		String wave[] = { "1", "22", "333", "4444", "55555", "666666",
				"7777777", "88888888", "999999999" };
		for (int r = 0; r < amplitude; r++) {
			System.out.println(wave[r]);
		}

		for (int s = amplitude - 2; s >= 0; s--) {
			System.out.println(wave[s]);
		}
	}
}