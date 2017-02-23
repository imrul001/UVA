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
				"/home/imrul/eclipseProjects/UVA/src/uva10010/input.txt"));
		String line;
		while ((line = reader.readLine()) != null) {
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
						dataArray[x][y] = lineArray[c];
						c++;
					}
				}
				int numberOfWords = Integer.parseInt(reader.readLine());
				String words[] = new String[numberOfWords];
				for (int k = 0; k < numberOfWords; k++) {
					words[k] = reader.readLine();
				}
				// printDataArray(dataArray);
				// printArray(word);
				for (int p = 0; p < words.length; p++) {
					List<Cell> cellList = getFirstCharacterCell(dataArray,
							words[0].charAt(0), column);
					for (Cell cell : cellList) {
						if (searchWord(cell, dataArray, words[p], column)) {
							System.out.println(cell.getX_position() + " "
									+ cell.getY_position());
						}
					}
				}
			}
		}
	}

	void printDataArray(char[][] array) {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 11; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

	void printArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	boolean searchWord(Cell startingCell, char[][] dataGrid, String word,
			int maxColumn) {
		boolean flag = false;
		List<Cell> cellList = getNextCellsList(startingCell, dataGrid,
				word.charAt(1), maxColumn);
		Cell lastCell = startingCell;
		for (Cell currentCell : cellList) {
			for (int i = 2; i < word.length(); i++) {
				char nextChar = word.charAt(i);
				int location[] = getNextCellLocation(lastCell, currentCell);
				if (dataGrid[location[0]][location[1]] == nextChar) {
					flag = true;
					lastCell = currentCell;
					currentCell = new Cell(nextChar, location[0], location[1]);
				} else {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	List<Cell> getNextCellsList(Cell startingCell, char[][] dataGrid,
			char secondChar, int maxColumn) {
		List<Cell> cellList = new ArrayList<Cell>();
		int startX = startingCell.getX_position() - 1 >= 1 ? startingCell
				.getX_position() - 1 : startingCell.getX_position();
		int startY = startingCell.getY_position() - 1 >= 1 ? startingCell
				.getY_position() - 1 : startingCell.getY_position() - 1;
		int endX = startingCell.getX_position() + 1 <= maxColumn ? startingCell
				.getX_position() + maxColumn : startingCell.getX_position();
		int endY = startingCell.getY_position() + 1 <= maxColumn ? startingCell
				.getY_position() + maxColumn : startingCell.getY_position();

		for (int i = startX; i <= endX; i++) {
			for (int j = startY; j <= endY; j++) {
				if (dataGrid[i][j] == secondChar) {
					Cell c1 = new Cell(secondChar, i, j);
					cellList.add(c1);
				}
			}
		}

		return cellList;
	}

	int[] getNextCellLocation(Cell lastCell, Cell currentCell) {
		int location[] = new int[2];
		int diffX = lastCell.getX_position() - currentCell.getX_position();
		int diffY = lastCell.getY_position() - currentCell.getY_position();
		location[0] = currentCell.getX_position() - (diffX);
		location[1] = currentCell.getY_position() - (diffY);
		return location;
	}

	List<Cell> getFirstCharacterCell(char[][] dataGrid, char firstChar,
			int maxColumn) {
		int c = 1;
		int row = 0;
		int column = 0;
		List<Cell> cellList = new ArrayList<Cell>();
		for (int i = 1; i < dataGrid.length - 1; i++) {
			if (dataGrid[i][c] == firstChar) {
				row = i;
				column = c;
				cellList.add(new Cell(firstChar, row, column));
			}
			c++;
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