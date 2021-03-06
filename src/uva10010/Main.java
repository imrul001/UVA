/**
 * 
 */
package uva10010;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author imrul
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		Main myWork = new Main();
		myWork.Begin();
	}

	/**
	 * @throws IOException
	 * 
	 */
	private void Begin() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"F:\\imrul\\workspace\\UVA\\src\\uva10010\\input.txt"));
		// BufferedReader reader = new BufferedReader(new InputStreamReader(
		// System.in));
		String line = reader.readLine();
		int testCases = Integer.parseInt(line);
		for (int i = 0; i < testCases; i++) {
			reader.readLine();
			String dimention[] = reader.readLine().split(" ");
			int row = Integer.parseInt(dimention[0]);
			int column = Integer.parseInt(dimention[1]);
			char dataArray[][] = new char[row + 1][column + 1];
			for (int x = 1; x <= row; x++) {
				char[] lineArray = reader.readLine().toCharArray();
				int c = 0;
				for (int y = 1; y <= column; y++) {
					dataArray[x][y] = Character.toLowerCase(lineArray[c]);
					c++;
				}
			}
			int numberOfWords = Integer.parseInt(reader.readLine());
			String word;
			for (int k = 0; k < numberOfWords; k++) {
				word = reader.readLine().toLowerCase();
				List<Cell> cellList = getFirstCharacterCell(dataArray,
						word.charAt(0), row, column);
				Cell resultingCell = new Cell();
				resultingCell = searchAndPrintCell(cellList, dataArray, word,
						row, column);

				if (resultingCell != null) {
					System.out.println(resultingCell.getX_position() + " "
							+ resultingCell.getY_position());
				}
			}
			if (i != testCases - 1) {
				System.out.println();
			}
		}
	}

	Cell searchAndPrintCell(List<Cell> cellList, char[][] dataArray,
			String word, int row, int column) {
		Cell resultingcell = new Cell();
		for (Cell cell : cellList) {
			if (searchWord(cell, dataArray, word, row, column)) {
				resultingcell = cell;
				break;
			}
		}
		return resultingcell;
	}

	// This method causing wrong answer, should be resolved
	boolean searchWord(Cell startingCell, char[][] dataGrid, String word,
			int maxRow, int maxColumn) {
		boolean flag = false;
		if (word.length() == 1) {
			return flag = true;
		} else {
			List<Cell> cellList = getNextCellsList(startingCell, dataGrid,
					word.charAt(1), maxRow, maxColumn);
			if (word.length() == 2 && cellList.size() > 0) {
				return flag = true;
			} else {
				for (Cell currentCell : cellList) {
					Cell lastCell = startingCell;
					for (int i = 2; i < word.length(); i++) {
						char nextChar = word.charAt(i);
						int location[] = getNextCellLocation(lastCell,
								currentCell);
						if (isValidLocation(location, maxRow, maxColumn)) {
							if (dataGrid[location[0]][location[1]] == nextChar) {
								flag = true;
								lastCell = currentCell;
								currentCell = new Cell(nextChar, location[0],
										location[1]);
							} else {
								flag = false;
								break;
							}
						} else {
							flag = false;
							break;
						}
					}
					if (flag) {
						break;
					}
				}
			}
		}
		return flag;
	}

	boolean isValidLocation(int[] location, int maxRow, int maxColumn) {
		boolean flag = false;
		if (location[0] >= 1 && location[0] <= maxRow && location[1] >= 1
				&& location[1] <= maxColumn) {
			flag = true;
		}
		return flag;
	}

	// Find outs the cells that contains the second character of the word
	List<Cell> getNextCellsList(Cell startingCell, char[][] dataGrid,
			char secondChar, int maxRow, int maxColumn) {
		List<Cell> cellList = new ArrayList<Cell>();
		int startX = startingCell.getX_position() - 1 >= 1 ? startingCell
				.getX_position() - 1 : startingCell.getX_position();
		int startY = startingCell.getY_position() - 1 >= 1 ? startingCell
				.getY_position() - 1 : startingCell.getY_position();
		int endX = startingCell.getX_position() + 1 <= maxRow ? startingCell
				.getX_position() + 1 : startingCell.getX_position();
		int endY = startingCell.getY_position() + 1 <= maxColumn ? startingCell
				.getY_position() + 1 : startingCell.getY_position();

		for (int i = startX; i <= endX; i++) {
			for (int j = startY; j <= endY; j++) {
				if (startingCell.getX_position() != i
						|| startingCell.getY_position() != j) {
					if (dataGrid[i][j] == secondChar) {
						Cell c1 = new Cell(secondChar, i, j);
						cellList.add(c1);
					}
				}
			}
		}
		return cellList;
	}

	// Find the next cell location based on previous two cells
	int[] getNextCellLocation(Cell lastCell, Cell currentCell) {
		int location[] = new int[2];
		int diffX = lastCell.getX_position() - currentCell.getX_position();
		int diffY = lastCell.getY_position() - currentCell.getY_position();
		location[0] = currentCell.getX_position() - (diffX);
		location[1] = currentCell.getY_position() - (diffY);
		return location;
	}

	// Finds out the cells that contains the first character of the word
	List<Cell> getFirstCharacterCell(char[][] dataGrid, char firstChar,
			int maxRow, int maxColumn) {
		int row = 0;
		int column = 0;
		List<Cell> cellList = new ArrayList<Cell>();
		for (int i = 1; i <= maxRow; i++) {
			for (int j = 1; j <= maxColumn; j++) {
				if (dataGrid[i][j] == firstChar) {
					row = i;
					column = j;
					cellList.add(new Cell(firstChar, row, column));
				}
			}
		}
		return cellList;
	}
}

class Cell {
	char character;
	int x_position;
	int y_position;

	public Cell(char character, int x_position, int y_position) {
		super();
		this.character = character;
		this.x_position = x_position;
		this.y_position = y_position;
	}

	public Cell() {
		// TODO Auto-generated constructor stub
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public int getX_position() {
		return x_position;
	}

	public void setX_position(int x_position) {
		this.x_position = x_position;
	}

	public int getY_position() {
		return y_position;
	}

	public void setY_position(int y_position) {
		this.y_position = y_position;
	}

}