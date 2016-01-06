class TetrisBoard {

	int boardWidth
	int boardLength

	int[][] filledBoardCells


	TetrisBoard(def boardLength, def boardWidth) {
		this.boardLength = boardLength
		this.boardWidth = boardWidth
		filledBoardCells = new int[boardLength][boardWidth]
	}



	def boardIsFilled() {
		return getFilledLevel() >= boardLength
	}


	def getFilledLevel() {
		def maxFilledLevelOnBoard = 0
		for(def i = 0; i < boardWidth; i++) {
			def maxLevelOnColumn = getMaxLevelOnColumn(i)
			if(maxFilledLevelOnBoard < maxLevelOnColumn) {
				maxFilledLevelOnBoard = maxLevelOnColumn
			}
		}

		return maxFilledLevelOnBoard
	}

	private int getMaxLevelOnColumn(int columnIndex) {
		def maxLevel = 0
		for (def i = 0; i < boardLength; i++) {
			if (filledBoardCells[i][columnIndex] == 1) {
				maxLevel++
			} else {
				return maxLevel
			}
		}
		return maxLevel

	}


	def markPositionAsFilled(int length, int width) {
		filledBoardCells[length][width] = 1
	}


	def markPositionAsUnFilled(int length, int width) {
		filledBoardCells[length][width] = 0
	}

}
