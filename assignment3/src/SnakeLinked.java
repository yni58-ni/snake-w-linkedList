/**
 * This class stores the information about the snake as it moves around the
 * board
 * 
 * @author Nicole Ni
 * @param snakeLenght: the number of tiles of the game board occupied by the
 *                     snake
 * @param snakeBody:   the positions of the tiles of the game board occupied by
 *                     the snake will be stored in this doubly linked list
 */
public class SnakeLinked {
	int snakeLength;
	DoubleList<Position> snakeBody;

	/**
	 * constructor
	 */
	public SnakeLinked(int row, int col) {
		snakeLength = 1;
		snakeBody = new DoubleList<Position>();
		Position snakeHeadPosition = new Position(row, col);
		snakeBody.addData(0, snakeHeadPosition);
	}

	/**
	 * returns the value of instance variable snakeLength
	 */
	public int getLength() {
		return snakeLength;
	}

	/**
	 * returns the Position object stored in the node of the doubly linked list with
	 * the given index
	 */
	public Position getPosition(int index) {
		if (index < 0 || index >= snakeLength) {
			return null;
		} else {
			return snakeBody.getData(index);
		}
	}

	/**
	 * returns true if pos is in the doubly linked list of snakeBody, and it returns
	 * false otherwise.
	 */
	public boolean snakePosition(Position pos) {
		for (int i = 0; i < snakeLength; i++) {
			if (pos.equals(snakeBody.getData(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * returns the new position that the head of the snake would occupy if the snake
	 * moved in the direction specified by the parameter
	 */
	public Position newHeadPosition(String direction) {
		int newHeadRow = 0;
		int newHeadCol = 0;
		Position newHead = new Position(newHeadRow, newHeadCol);
		int currentHeadRow = snakeBody.getData(0).getRow();
		int currentHeadCol = snakeBody.getData(0).getCol();
		if (direction == "right") {
			newHeadRow = currentHeadRow;
			newHeadCol = currentHeadCol + 1;
			newHead = new Position(newHeadRow, newHeadCol);
		} else if (direction == "left") {
			newHeadRow = currentHeadRow;
			newHeadCol = currentHeadCol - 1;
			newHead = new Position(newHeadRow, newHeadCol);
		} else if (direction == "down") {
			newHeadRow = currentHeadRow + 1;
			newHeadCol = currentHeadCol;
			newHead = new Position(newHeadRow, newHeadCol);
		} else if (direction == "up") {
			newHeadRow = currentHeadRow - 1;
			newHeadCol = currentHeadCol;
			newHead = new Position(newHeadRow, newHeadCol);
		}
		return newHead;
	}

	/**
	 * moves the snake in the specified direction
	 */
	public void moveSnakeLinked(String direction) {
		DoubleList<Position> snakeBody1 = new DoubleList<Position>(); // create the new array to store the information
																		// from the previous one
		if (direction.equals("right")) {
			snakeBody1.addData(0, newHeadPosition("right"));
			for (int i = 1; i <= snakeLength - 1; i++) {
				snakeBody1.addData(i, snakeBody.getNode(i - 1).getData());
			}
			snakeBody = snakeBody1;
		} else if (direction.equals("left")) {
			snakeBody1.addData(0, newHeadPosition("left"));
			for (int i = 1; i <= snakeLength - 1; i++) {
				snakeBody1.addData(i, snakeBody.getNode(i - 1).getData());
			}
			snakeBody = snakeBody1;
		} else if (direction.equals("up")) {
			snakeBody1.addData(0, newHeadPosition("up"));
			for (int i = 1; i <= snakeLength - 1; i++) {
				snakeBody1.addData(i, snakeBody.getNode(i - 1).getData());
			}
			snakeBody = snakeBody1;
		} else if (direction.equals("down")) {
			snakeBody1.addData(0, newHeadPosition("down"));
			for (int i = 1; i <= snakeLength - 1; i++) {
				snakeBody1.addData(i, snakeBody.getNode(i - 1).getData());
			}
			snakeBody = snakeBody1;
		}
	}

	/**
	 * decreases the value of snakeLength by 1 and deletes the last node in the
	 * doubly linked list of snakeBody.
	 */
	public void shrink() {
		snakeBody.removeData(snakeLength - 1);
		snakeLength--;
	}

	/**
	 * increases the length of the snake by 1 and moves the snake’s head in the
	 * direction specified
	 */
	void grow(String direction) {
		DoubleList<Position> snakeBody2 = new DoubleList<Position>();
		if (direction.equals("right")) {
			snakeBody2.addData(0, newHeadPosition("right"));
			for (int i = 1; i <= snakeLength; i++) {
				snakeBody2.addData(i, snakeBody.getNode(i - 1).getData());
			}
			snakeLength = snakeLength + 1;
			snakeBody = snakeBody2;
		} else if (direction.equals("left")) {
			snakeBody2.addData(0, newHeadPosition("left"));
			for (int i = 1; i <= snakeLength; i++) {
				snakeBody2.addData(i, snakeBody.getNode(i - 1).getData());
			}
			snakeLength = snakeLength + 1;
			snakeBody = snakeBody2;
		} else if (direction.equals("up")) {
			snakeBody2.addData(0, newHeadPosition("up"));
			for (int i = 1; i <= snakeLength; i++) {
				snakeBody2.addData(i, snakeBody.getNode(i - 1).getData());
			}
			snakeLength = snakeLength + 1;
			snakeBody = snakeBody2;
		} else if (direction.equals("down")) {
			snakeBody2.addData(0, newHeadPosition("down"));
			for (int i = 1; i <= snakeLength; i++) {
				snakeBody2.addData(i, snakeBody.getNode(i - 1).getData());
			}
			snakeLength = snakeLength + 1;
			snakeBody = snakeBody2;
		}
	}
}
