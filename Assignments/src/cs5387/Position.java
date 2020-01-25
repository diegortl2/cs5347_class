package cs5387;

public class Position {
	public int row;
	public int col;
	private int max;
	
	public Position(int rowIndex, int colIndex, int range) {
		row = rowIndex;
		col = colIndex;
		max = range;
	}
	
	public Position getNext() {
		if((col+1) < max) {
			return new Position(row,col + 1, max);
		}
		else if((row + 1) < max) {
			return new Position(row + 1, 0, max);
		}
		return null;
	}
	
	public Position getPrev() {
		if((col-1) >= 0) {
			return new Position(row,col - 1, max);
		}
		else if((row - 1) >= 0) {
			return new Position(row - 1, max-1, max);
		}
		return new Position(row - 1, max-1, max);
	}
	
	public boolean equals (Position pos) {
		if(this.row == pos.row && this.col == pos.col) {
			return true;
		}
		return false;
	}
	
	public boolean smallerThan(Position pos) {
		if(this.row<pos.row) {
			return true;
		}
		else if (this.row == pos.row && this.col < pos.col) {
			return true;
		}
		return false;
	}
}
