/**
 * This class represents the board game where the snake moves around eating
 * apples
 * 
 * @author Nicole Ni
 *
 */
public class BoardGameLinked {
	int boardLength;
	int boardWidth;
	SnakeLinked theSnake;
	DoubleList<String>[] board;

	/**
	 * Constructor
	 * 
	 * @param the txt file contents position information
	 */
	public BoardGameLinked(String boardFile) {
		MyFileReader in;
		in = new MyFileReader(boardFile);

		int gridWidth = in.readInt(); // first number
		int gridLength = in.readInt(); // second number
		boardLength = in.readInt(); // third number
		boardWidth = in.readInt(); // fourth number
		board = new DoubleList[boardWidth]; // define the length of board

		int snakePosition1 = in.readInt(); // fifth number
		int snakePosition2 = in.readInt(); // sixth number
		theSnake = new SnakeLinked(snakePosition1, snakePosition2); // set the snake starting position

		for (int i = 0; i < boardWidth; i++) {
			board[i] = new DoubleList<String>();
		}

		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardLength; j++) {
				board[i].addData(j, "empty"); // initialize tiles to empty
			}
		}

		while (in.endOfFile() == false) {
			int number1 = in.readInt(); // start reading from the seventh number
			int number2 = in.readInt();
			String string1 = in.readString();
			board[number1].setData(number2, string1);
		}
	}

	/**
	 * Return the string stored in the node with index
	 */
	public String getObject(int row, int col) throws InvalidPositionException {
		if (row >= boardWidth || col >= boardLength || row < 0 || col < 0) {
			throw new InvalidPositionException("Invalid Position Index");
		} else {
			return board[row].getData(col);
		}
	}

	/**
	 * Store newObject in the node with index
	 */
	public void setObject(int row, int col, String newObject) throws InvalidPositionException {
		if (row >= boardWidth || col >= boardLength || row < 0 || col < 0) {
			throw new InvalidPositionException("Invalid Position Index");
		} else {
			board[row].setData(col, newObject);
		}
	}

	/**
	 * return theSnake
	 */
	public SnakeLinked getSnakeLinked() {
		return theSnake;
	}

	/**
	 * store the value of newSnake in instance variable
	 */
	public void setSnakeLinked(SnakeLinked newSnake) {
		theSnake = newSnake;
	}

	/**
	 * get boardLength
	 * 
	 * @return boardLength
	 */
	public int getLength() {
		return boardLength;
	}

	/**
	 * get boardWidth
	 */
	public int getWidth() {
		return boardWidth;
	}

}
