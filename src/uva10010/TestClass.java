package uva10010;

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
		assertEquals(4, m1.getFirstCharacterCell(getDataGrid(), 'g', 8, 11)
				.size());
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
		Cell startingCell = new Cell('s', 4, 9);
		char secondChar = 'r';
		int maxRow = 8;
		int maxColumn = 11;

		List<Cell> cellList = m1.getNextCellsList(startingCell, getDataGrid(),
				secondChar, maxRow, maxColumn);
		assertEquals(4, cellList.get(1).x_position);
		Cell expectedCell1 = new Cell('r', 3, 10);
		Cell expectedCell2 = new Cell('r', 4, 10);
		assertEquals(expectedCell1.x_position, cellList.get(0).getX_position());
		assertEquals(expectedCell2.x_position, cellList.get(1).getX_position());
	}

	@Test
	public void testGetSearchMatrix() {
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
		String[] array = m1.getSearchMatrix(new Cell('y', 8, 1), 8, 11).split(
				" ");
		int startX = Integer.valueOf(array[0]);
		int startY = Integer.valueOf(array[1]);
		int endX = Integer.valueOf(array[2]);
		int endY = Integer.valueOf(array[3]);
		assertEquals(7, startX);
		assertEquals(1, startY);
		assertEquals(8, endX);
		assertEquals(2, endY);
	}

	// this method causing runtime error, which must be investigated
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

		int[] location = m1.getNextCellLocation(new Cell('e', 2, 2), new Cell(
				'a', 1, 1));
		assertEquals(0, location[0]);
		assertEquals(0, location[1]);
	}
}
