import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.Begin();
	}

	void Begin() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		while ((line = reader.readLine()) != null) {
			int testCases = Integer.parseInt(line);
			for (int i = 0; i < testCases; i++) {
				List<Farmer> farmerList = new ArrayList<Farmer>();
				int numberOfFarmers = Integer.parseInt(reader.readLine());
				for (int j = 0; j < numberOfFarmers; j++) {
					StringTokenizer st = new StringTokenizer(reader.readLine());
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					Farmer farmer = new Farmer(a, b, c);
					farmerList.add(farmer);
				}
				print(farmerList);
				farmerList = null;
			}
		}
	}

	void print(List<Farmer> farmerList) {
		int sum = 0;
		for (Farmer farmer : farmerList) {
			sum += farmer.getPremium();
		}
		System.out.println(sum);
	}
}

class Farmer {
	int premium;

	public int getPremium() {
		return premium;
	}

	public Farmer(int farmSize, int numberOfAnimals, int friendliness) {
		super();
		this.premium = (farmSize * friendliness);

	}
}
