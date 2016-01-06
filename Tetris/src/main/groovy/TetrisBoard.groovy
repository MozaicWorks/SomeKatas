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
			def maxLevelOnLength = 0
			for(def j =0; j < boardLength; j++) {
				if(filledBoardCells[j][i] == 1)	{
					maxLevelOnLength++
				}  else {
					break
				}
			}
			if(maxFilledLevelOnBoard < maxLevelOnLength) {
				maxFilledLevelOnBoard = maxLevelOnLength
			}
		}

		return maxFilledLevelOnBoard
	}



	def markPositionAsFilled(int length, int width) {
		filledBoardCells[length][width] = 1
	}


	def markPositionAsUnFilled(int length, int width) {
		filledBoardCells[length][width] = 0
	}

}
