package jam.google.watershreds;

import java.util.ArrayList;
import java.util.Collection;

public final class Cell {

	public final Map map;
	public final int row;
	public final int column;
	public final int altitude;
	
	private char notation;
	
	public Cell(Map map, int row, int column, int altitude) {
		this.map = map;
		this.row = row;
		this.column = column;
		this.altitude = altitude;
	}
	
	public char getNotation() {
		return this.notation;
	}
	
	public void setNotation(char notation) {
		this.notation = notation;
	}
	
	public boolean hasNorth() {
		return this.row > 0;
	}
	
	public boolean hasSouth() {
		return this.row < this.map.getRowCount() - 1;
	}
	
	public boolean hasWest() {
		return this.column > 0;
	}
	
	public boolean hasEast() {
		return this.column < this.map.getColumnCount() - 1;
	}
	
	public Cell north() {
		return this.map.getCell(this.row - 1, this.column);
	}
	
	public Cell south() {
		return this.map.getCell(this.row + 1, this.column);
	}
	
	public Cell west() {
		return this.map.getCell(this.row, this.column - 1);
	}
	
	public Cell east() {
		return this.map.getCell(this.row, this.column + 1);
	}
	
	public Collection<Cell> getNeighbours() {
		Collection<Cell> neihbours = new ArrayList<>();
    	
    	if (this.hasNorth()) {
    		neihbours.add(this.north());
    	}
    	
    	if (this.hasWest()) {
    		neihbours.add(this.west());
    	}
    	
    	if (this.hasEast()) {
    		neihbours.add(this.east());
    	}
    	
    	if (this.hasSouth()) {
    		neihbours.add(this.south());
    	}
    	
    	return neihbours;
	}
	
	public Cell getLowestNeighbour() {
		Cell result = null;
		
		for (Cell c : this.getNeighbours()) {
			if (result == null || result.altitude > c.altitude) {
				result = c;
			}
		}
		
		return result;
	}
	
	public String toString() {
		return String.format("(%d, %d)", this.row, this.column);
	}
}
