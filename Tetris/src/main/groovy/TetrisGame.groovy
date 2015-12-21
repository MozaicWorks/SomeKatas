class TetrisGame {
	boolean[][] filledBoardCells
	int filledLevel
	int currentHeightPosition

	int boardWidth
	int boardHeight

	TetrisGame(def boardWidth, def boardHeight) {
		this.boardWidth = boardWidth
		this.boardHeight = boardHeight
		filledBoardCells = new boolean[boardWidth][boardHeight]
		currentHeightPosition = boardHeight
	}


	TetrisGame() {

	}

	def blockFalls() {
		if(canFall()) {
			fall()
		}
	}

	private void fall() {
		filledBoardCells[0][filledLevel] = true
		filledLevel++
	}

	private boolean canFall() {
		filledLevel <= boardHeight
	}

	def isGameOver() {
		return filledLevel >= boardHeight
	}

	def playGame() {
		while (!isGameOver()) {
			blockFalls()
		}
	}

	def fallsOneCell() {
		currentHeightPosition --;
		filledBoardCells[0][currentHeightPosition] = true
		filledLevel++
	}


}
