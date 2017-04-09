package uva10194;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.begin();
	}

	void begin() throws IOException {
		// BufferedReader reader = new BufferedReader(new FileReader(
		// "/home/linux/tutorial/UVA/src/uva10194/input.txt"));

		BufferedReader reader = new BufferedReader(new FileReader(
				"F:\\imrul\\workspace\\UVA\\src\\uva10194\\input.txt"));
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
				solve(teams, results, nameOfTournament);
			}
		}

	}

	private void solve(List<Team> teams, List<String> results,
			String nameOfTournament) {
		int index = 0;
		List<Team> processedTeams = new ArrayList<Team>();
		for (Team team : teams) {
			String name = team.getName();
			int gamePlayed = 0, win = 0, loss = 0, ties = 0, goalScored = 0, goalAgainst = 0;
			int count = 0;
			for (String result : results) {
				String[] parts = result.split("#");
				if (parts[0].equals(name) || parts[2].equals(name)) {
					count++;
					String[] goalParts = parts[1].split("@");
					if (parts[0].equals(name)) {
						gamePlayed++;
						goalScored = goalScored
								+ Integer.parseInt(goalParts[0]);
						goalAgainst = goalAgainst
								+ Integer.parseInt(goalParts[1]);
						if (Integer.parseInt(goalParts[0]) > Integer
								.parseInt(goalParts[1])) {
							win++;
						}
						if (Integer.parseInt(goalParts[1]) > Integer
								.parseInt(goalParts[0])) {
							loss++;
						}
						if (Integer.parseInt(goalParts[1]) == Integer
								.parseInt(goalParts[0])) {
							ties++;
						}
					} else {
						gamePlayed++;
						goalScored = goalScored
								+ Integer.parseInt(goalParts[1]);
						goalAgainst = goalAgainst
								+ Integer.parseInt(goalParts[1]);
						if (Integer.parseInt(goalParts[0]) > Integer
								.parseInt(goalParts[1])) {
							loss++;
						}
						if (Integer.parseInt(goalParts[1]) > Integer
								.parseInt(goalParts[0])) {
							win++;
						}
						if (Integer.parseInt(goalParts[1]) == Integer
								.parseInt(goalParts[0])) {
							ties++;
						}
					}
				}
				if (count == teams.size() - 1) {
					break;
				}
			}
			team.setWin(win);
			team.setGamePlayed(gamePlayed);
			team.setLoss(loss);
			team.setTies(ties);
			team.setGoalScored(goalScored);
			team.setGoatAgainst(goalAgainst);
			team.setGoalDifference(goalScored - goalAgainst);
			team.setPoints(getPoints(win, loss, ties));
			processedTeams.add(team);
			index++;

		}
		Collections.reverse(processedTeams);
		printResult(processedTeams, nameOfTournament);

	}

	private void printResult(List<Team> teams, String nameOfTournament) {
		System.out.println(nameOfTournament);
		int index = 1;
		for (Team team : teams) {
			System.out.println(index + ") " + team.getName() + " "
					+ team.getPoints() + "p, " + team.getGamePlayed() + "g ("
					+ team.getWin() + "-" + team.getTies() + "-"
					+ team.getLoss() + "), " + team.getGoalDifference()
					+ "gd (" + team.getGoalScored() + "-"
					+ team.getGoatAgainst() + ")");
			index++;
		}
	}

	private int getPoints(int win, int loss, int ties) {
		return (win * 3) + (loss * 0) + (ties * 1);
	}
}

class Team implements Comparable<Team> {
	private String name;
	private int gamePlayed;
	private int win;
	private int loss;
	private int ties;
	private int goalScored;
	private int goatAgainst;
	private int goalDifference;
	private int points;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGamePlayed() {
		return gamePlayed;
	}

	public void setGamePlayed(int gamePlayed) {
		this.gamePlayed = gamePlayed;
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

	public int getTies() {
		return ties;
	}

	public void setTies(int ties) {
		this.ties = ties;
	}

	public int getGoalScored() {
		return goalScored;
	}

	public void setGoalScored(int goalScored) {
		this.goalScored = goalScored;
	}

	public int getGoatAgainst() {
		return goatAgainst;
	}

	public void setGoatAgainst(int goatAgainst) {
		this.goatAgainst = goatAgainst;
	}

	public int getGoalDifference() {
		return goalDifference;
	}

	public void setGoalDifference(int goalDifference) {
		this.goalDifference = goalDifference;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Team(String name) {
		this.name = name;
	}

	public int compareTo(Team o) {
		return this.points - o.points;
	}

}
