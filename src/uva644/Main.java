package uva644;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		// myWork.begin();
		String str1 = "01";
		String str2 = "011";
		System.out.println(str2.substring(0, 2));
	}

	private void begin() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"F:\\imrul\\workspace\\UVA\\src\\uva644\\input.txt"));
		String line;
		List<String> codes = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
			if (!line.equals("9")) {
				codes.add(line);
			} else {
				System.out.println(codes);
				codes.removeAll(codes);
			}
		}
	}

	boolean isDecodeable(List<String> codes) {
		boolean flag = false;
		for (String code : codes) {
			String prefix = code;
			for (String codeAgain : codes) {
				if (!codeAgain.equals(prefix)) {
					if (isPrefixMatch(prefix, codeAgain)) {
						flag = true;
						break;
					}
				}
			}
		}
		return flag;
	}

	boolean isPrefixMatch(String prefix, String code) {
		boolean flag = false;
		int prefixLength = prefix.length();
		int codeLength = code.length();
		if (codeLength < prefixLength) {
			flag = false;
		} else {
			if (prefix.equals(code.substring(0, prefixLength))) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
}
