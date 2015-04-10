package jam.google.watershreds;

public final class Map {

	private Cell[][] cells;
	
	public Map(int[][] values) {
		this.cells = new Cell[values.length][];
		
		for (int i = 0; i < values.length; i++) {
			this.cells[i] = new Cell[values[i].length];
			
			for (int j = 0; j < values[i].length; j++) {
				this.cells[i][j] = new Cell(this, i, j, values[i][j]);
			}
		}
	}
	
	public int getRowCount() {
		return this.cells.length;
	}
	
	public int getColumnCount() {
		return this.cells[0].length;
	}
	
	public Cell getCell(int row, int column) {
		return this.cells[row][column];
	}
}
