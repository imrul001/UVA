import java.math.BigInteger;
import java.util.Scanner;

class Main10013 {
	public static void main(String[] args) {
		Main10013 myWork = new Main10013();
		myWork.Begin();
	}

	void Begin() {
		Scanner idata = new Scanner(System.in);
		int operations, size;
		String num1 = "", num2 = "";

		operations = idata.nextInt();
		System.out.println();

		for (int i = 0; i < operations; i++) {
			size = idata.nextInt();
			for (int j = 0; j < size; j++) {
				num1 += String.valueOf(idata.nextInt());
				num2 += String.valueOf(idata.nextInt());
			}
			System.out.println();
			BigInteger integer1 = new BigInteger(num1);
			BigInteger integer2 = new BigInteger(num2);
			integer1 = integer1.add(integer2);
			System.out.println(integer1);
			System.out.println();
		}

	}
}
