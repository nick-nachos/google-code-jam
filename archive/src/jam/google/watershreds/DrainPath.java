package jam.google.watershreds;

import java.util.ArrayList;
import java.util.Iterator;

public final class DrainPath implements Iterable<Cell> {

	private ArrayList<Cell> cells;
	private char notation;
	
	public DrainPath() {
		this.cells = new ArrayList<>();
	}
	
	public void add(Cell c) {
		this.cells.add(c);
		
		if (c.getNotation() != 0) {
			this.notation = c.getNotation();
		}
	}
	
	public char getNotation() {
		return this.notation;
	}

	@Override
	public Iterator<Cell> iterator() {
		return cells.iterator();
	}
}
