package uva490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.Begin();
	}

	void Begin() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		List<String> list = new ArrayList<String>();
		int maxLength = 0;
		while ((line = reader.readLine()) != null) {
			String str = line;
			int temp = str.length();
			maxLength = temp > maxLength ? temp : maxLength;
			list.add(str);
		}
		for (int j = 0; j < maxLength; j++) {
			String result = "";
			for (int i = list.size() - 1; i >= 0; i--) {
				int length = list.get(i).length();
				if (j > length - 1 && maxLength > length) {
					result += " ";
				} else {
					result += list.get(i).charAt(j);
				}
			}
			System.out.println(result);
		}
	}
}