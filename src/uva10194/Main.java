package uva10194;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	void begin() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"/home/linux/tutorial/UVA/src/uva10194/input.txt"));
		String line;
		while ((line = reader.readLine()) != null) {
			int numberOfTestCases = Integer.parseInt(line);
			for (int i = 0; i < numberOfTestCases; i++) {
				String nameOfTournament = reader.readLine();
				int numberOfTeams = Integer.parseInt(reader.readLine());
				List<Team> teams = new ArrayList<Team>();
				for (int j = 0; j < numberOfTeams; j++) {
					teams.add(new Team(reader.readLine()));
				}
				int numberOfResults = Integer.parseInt(reader.readLine());
				List<String> results = new ArrayList<String>();
				for (int k = 0; k < numberOfResults; k++) {
					results.add(reader.readLine());
				}
				solve(teams, results);
			}
		}

	}

	private void solve(List<Team> teams, List<String> results) {
		for (Team team : teams) {
			String name = team.getName();
			int points = 0, goal = 0, win = 0, lose = 0, conGoal = 0;
			int count = 0;
			for (String result : results) {
				String[] parts = result.split("#");
				if (parts[0].equals(name) || parts[2].equals(name)) {
					count++;
					String[] goalParts = parts[1].split("@");
					if (parts[0].equals(name)) {
						goal = goal + Integer.parseInt(goalParts[0]);
						conGoal = conGoal + Integer.parseInt(goalParts[1]);
					} else {
						goal = goal + Integer.parseInt(goalParts[1]);
						conGoal = conGoal + Integer.parseInt(goalParts[1]);
					}
				}
				if (count == teams.size() - 1) {
					break;
				}
			}
		}

	}
}

class Team implements Comparable<Team> {
	private String name;
	private int win;
	private int loss;
	private int draw;
	private int goal;
	private int conGoal;
	private int points;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLoss() {
		return loss;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int getConGoal() {
		return conGoal;
	}

	public void setConGoal(int conGoal) {
		this.conGoal = conGoal;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Team(String name, int win, int loss, int draw, int goal,
			int conGoal, int points) {
		super();
		this.name = name;
		this.win = win;
		this.loss = loss;
		this.draw = draw;
		this.goal = goal;
		this.conGoal = conGoal;
		this.points = points;
	}

	public Team(String name) {
		this.name = name;
	}

	public int compareTo(Team o) {
		return this.points - o.points;
	}

}
