package uva10010;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class TestClass extends TestCase {
	private char[][] dataGrid;

	public char[][] getDataGrid() {
		return dataGrid;
	}

	public void setDataGrid(char[][] dataGrid) {
		char dataArray[][] = new char[8 + 1][11 + 1];
		int i = 1;
		int j = 1;
		for (int x = 0; x < 8; x++) {
			i = x + 1;
			for (int y = 0; y < 11; y++) {
				j = y + 1;
				dataArray[i][j] = Character.toLowerCase(dataGrid[x][y]);
			}
		}
		this.dataGrid = dataArray;
	}

	@Test
	public void testGetFirstCharacterCell() {
		char[][] dataArray = new char[][] {
				{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'g' },
				{ 'h', 'e', 'b', 'k', 'w', 'a', 'l', 'd', 'o', 'r', 'k' },
				{ 'f', 't', 'y', 'a', 'w', 'a', 'l', 'd', 'o', 'r', 'm' },
				{ 'f', 't', 's', 'i', 'm', 'r', 'l', 'q', 's', 'r', 'c' },
				{ 'b', 'y', 'o', 'a', 'r', 'b', 'e', 'd', 'e', 'y', 'v' },
				{ 'k', 'l', 'c', 'b', 'q', 'w', 'i', 'k', 'o', 'm', 'k' },
				{ 's', 't', 'r', 'e', 'b', 'g', 'a', 'd', 'h', 'r', 'b' },
				{ 'y', 'u', 'i', 'q', 'l', 'x', 'c', 'n', 'b', 'j', 'f' } };

		setDataGrid(dataArray);
		Main m1 = new Main();
		assertEquals(8, m1.getFirstCharacterCell(getDataGrid(), 'd', 8, 11)
				.get(1).getY_position());
	}

	@Test
	public void testGetNextCellsList() {
		char[][] dataArray = new char[][] {
				{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'g' },
				{ 'h', 'e', 'b', 'k', 'w', 'a', 'l', 'd', 'o', 'r', 'k' },
				{ 'f', 't', 'y', 'a', 'w', 'a', 'l', 'd', 'o', 'r', 'm' },
				{ 'f', 't', 's', 'i', 'm', 'r', 'l', 'q', 's', 'r', 'c' },
				{ 'b', 'y', 'o', 'a', 'r', 'b', 'e', 'd', 'e', 'y', 'v' },
				{ 'k', 'l', 'c', 'b', 'q', 'w', 'i', 'k', 'o', 'm', 'k' },
				{ 's', 't', 'r', 'e', 'b', 'g', 'a', 'd', 'h', 'r', 'b' },
				{ 'y', 'u', 'i', 'q', 'l', 'x', 'c', 'n', 'b', 'j', 'f' } };

		setDataGrid(dataArray);
		Main m1 = new Main();
		Cell startingCell = new Cell('d', 2, 8);
		char secondChar = 'o';
		int maxRow = 8;
		int maxColumn = 11;

		List<Cell> cellList = m1.getNextCellsList(startingCell, getDataGrid(),
				secondChar, maxRow, maxColumn);
		assertEquals(3, cellList.get(1).x_position);
		Cell expectedCell1 = new Cell('o', 2, 9);
		Cell expectedCell2 = new Cell('o', 3, 9);
		assertEquals(expectedCell1.x_position, cellList.get(0).getX_position());
		assertEquals(expectedCell2.x_position, cellList.get(1).getX_position());
	}

	@Test
	public void testGetNextCellLocation() {
		char[][] dataArray = new char[][] {
				{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'g' },
				{ 'h', 'e', 'b', 'k', 'w', 'a', 'l', 'd', 'o', 'r', 'k' },
				{ 'f', 't', 'y', 'a', 'w', 'a', 'l', 'd', 'o', 'r', 'm' },
				{ 'f', 't', 's', 'i', 'm', 'r', 'l', 'q', 's', 'r', 'c' },
				{ 'b', 'y', 'o', 'a', 'r', 'b', 'e', 'd', 'e', 'y', 'v' },
				{ 'k', 'l', 'c', 'b', 'q', 'w', 'i', 'k', 'o', 'm', 'k' },
				{ 's', 't', 'r', 'e', 'b', 'g', 'a', 'd', 'h', 'r', 'b' },
				{ 'y', 'u', 'i', 'q', 'l', 'x', 'c', 'n', 'b', 'j', 'f' } };

		setDataGrid(dataArray);
		Main m1 = new Main();

		int[] location = m1.getNextCellLocation(new Cell('o', 2, 9), new Cell(
				'r', 2, 10));
		assertEquals(2, location[0]);
		assertEquals(11, location[1]);
	}

	@Test
	public void testSearchWord() {
		char[][] dataArray = new char[][] {
				{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'g' },
				{ 'h', 'e', 'b', 'k', 'w', 'a', 'l', 'd', 'o', 'r', 'k' },
				{ 'f', 't', 'y', 'a', 'w', 'a', 'l', 'd', 'o', 'r', 'm' },
				{ 'f', 't', 's', 'i', 'm', 'r', 'l', 'q', 's', 'r', 'c' },
				{ 'b', 'y', 'o', 'a', 'r', 'b', 'e', 'd', 'e', 'y', 'v' },
				{ 'k', 'l', 'c', 'b', 'q', 'w', 'i', 'k', 'o', 'm', 'k' },
				{ 's', 't', 'r', 'e', 'b', 'g', 'a', 'd', 'h', 'r', 'b' },
				{ 'y', 'u', 'i', 'q', 'l', 'x', 'c', 'n', 'b', 'j', 'f' } };

		setDataGrid(dataArray);
		Main m1 = new Main();

		Cell startingCell = new Cell('d', 2, 8);
		assertEquals(true,
				m1.searchWord(startingCell, getDataGrid(), "dork", 8, 11));

	}

	@Test
	public void testSearchAndPrintCell() {
		char[][] dataArray = new char[][] {
				{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'g' },
				{ 'h', 'e', 'b', 'k', 'w', 'a', 'l', 'd', 'o', 'r', 'k' },
				{ 'f', 't', 'y', 'a', 'w', 'a', 'l', 'd', 'o', 'r', 'm' },
				{ 'f', 't', 's', 'i', 'm', 'r', 'l', 'q', 's', 'r', 'c' },
				{ 'b', 'y', 'o', 'a', 'r', 'b', 'e', 'd', 'e', 'y', 'v' },
				{ 'k', 'l', 'c', 'b', 'q', 'w', 'i', 'k', 'o', 'm', 'k' },
				{ 's', 't', 'r', 'e', 'b', 'g', 'a', 'd', 'h', 'r', 'b' },
				{ 'y', 'u', 'i', 'q', 'l', 'x', 'c', 'n', 'b', 'j', 'f' } };

		setDataGrid(dataArray);
		Main m1 = new Main();
		List<Cell> cellList = new ArrayList<Cell>();
		cellList.add(new Cell('a', 1, 1));
		cellList.add(new Cell('a', 2, 6));
		cellList.add(new Cell('a', 3, 4));
		cellList.add(new Cell('a', 3, 6));
		cellList.add(new Cell('a', 5, 4));
		cellList.add(new Cell('a', 7, 7));
		assertEquals(1,
				m1.searchAndPrintCell(cellList, getDataGrid(), "ab", 8, 11)
						.getX_position());
		assertEquals(1,
				m1.searchAndPrintCell(cellList, getDataGrid(), "ab", 8, 11)
						.getY_position());

	}

	@Test
	public void testIsValidLocation() {
		Main m1 = new Main();
		int[] location = new int[] { 2, 11 };
		assertEquals(true, m1.isValidLocation(location, 8, 11));
	}
}
