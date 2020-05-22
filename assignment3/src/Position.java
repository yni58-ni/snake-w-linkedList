/**
 * This method represents the position of a square of the grid.
 * 
 * @param positionRow    position of the row
 * @param positionColumn position of the column
 * @author Nicole Ni
 */
public class Position {
	/**
	 * Attribute declarations
	 */
	private int positionRow;
	private int positionColumn;

	/**
	 * Constructor
	 */
	public Position(int row, int col) {
		positionRow = row;
		positionColumn = col;
	}

	/**
	 * Getter method to get the value of positionRow
	 */
	public int getRow() {
		return positionRow;
	}

	/**
	 * Getter method to get the value of positionColumn
	 */
	public int getCol() {
		return positionColumn;
	}

	/**
	 * Setter method to store the value of newRow in positionRow
	 * 
	 * @param newRow a new value of row
	 */
	public void setRow(int newRow) {
		positionRow = newRow;
	}

	/**
	 * Setter method to store the value of newCol in positionColumn
	 * 
	 * @param newCol a new value of column
	 */
	public void setCol(int newCol) {
		positionColumn = newCol;
	}

	/**
	 * compare if two Position objects have the same value of positionRow and
	 * PositionColumn
	 */
	public boolean equals(Position otherPosition) {
		if (otherPosition.positionColumn == this.positionColumn && otherPosition.positionRow == this.positionRow) {
			return true;
		} else
			return false;
	}
}
