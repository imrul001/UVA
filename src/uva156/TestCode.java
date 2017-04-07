package uva156;

import java.util.Arrays;

public class TestCode {

	public static void main(String[] args) {
		String str1 = "disk";
		String str2 = "sikd";
		System.out.println(isSameWord(str1, str2));
	}

	private static boolean isSameWord(String firstStr, String secondStr) {
		char[] first = firstStr.toCharArray();
		char[] second = secondStr.toCharArray();
		Arrays.sort(first);
		Arrays.sort(second);
		return Arrays.equals(first, second);
	}

}
