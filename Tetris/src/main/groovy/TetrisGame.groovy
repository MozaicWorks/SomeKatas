class TetrisGame {

	TetrisPiece tetrisPiece
	TetrisBoard tetrisBoard



	TetrisGame(def boardLength, def boardWidth) {
		tetrisBoard = new TetrisBoard(boardLength, boardWidth)
		tetrisPiece = new TetrisPiece(boardLength, boardWidth/2)
	}


	def blockFalls() {
		if(!isGameOver()) {
			resetCurrentPosition()
			while (canFall()) {
				fallsOneCell()
			}
		}
	}

	def resetCurrentPosition() {
		tetrisPiece.currentLengthPosition = tetrisBoard.boardLength
	}



	def isGameOver() {
		return tetrisBoard.boardIsFilled()
	}

	def playGame() {
		while (!isGameOver()) {
			blockFalls()
		}
	}


	def fallsOneCell() {
		if(canFall()) {
			if (tetrisPiece.currentLengthPosition < tetrisBoard.boardLength) {
				tetrisBoard.markPositionAsUnFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition)
			}
			tetrisPiece.currentLengthPosition --;
			markCurrentPositionAsFilled()
			if(tetrisPiece.currentLengthPosition == tetrisBoard.filledLevel) {
				tetrisBoard.filledLevel ++
			}
		}


	}

	private def canFall() {
		tetrisPiece.currentLengthPosition > tetrisBoard.filledLevel
	}


	private void markCurrentPositionAsFilled() {
		tetrisBoard.filledBoardCells[tetrisPiece.currentLengthPosition][tetrisPiece.currentWidthPosition] = true
	}

	def isCellFromGivenPositionFilled(int givenLength, int givenWidth) {
		return tetrisBoard.filledBoardCells[givenLength][givenWidth]
	}

	def moveBlockToLeft() {
		if(canMoveLeft()) {
			tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition)
			tetrisPiece.currentWidthPosition--
			markCurrentPositionAsFilled()
		}
	}

	private boolean canMoveLeft() {
		tetrisPiece.currentWidthPosition > 0
	}

	def moveBlockToRight() {
		if(canMoveRight()) {
			tetrisBoard.markPositionAsUnFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition)
			tetrisPiece.currentWidthPosition++
			markCurrentPositionAsFilled()
		}
	}

	private boolean canMoveRight() {
		tetrisPiece.currentWidthPosition <  tetrisBoard.boardLength-1
	}


	def initializeIPiece() {
		tetrisPiece.currentLengthPosition --
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition-1)
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition)
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition+1)
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition+2)
	}

	def initializeJPiece() {
		tetrisPiece.currentLengthPosition --
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition-1)
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition)
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition+1)
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition-1, tetrisPiece.currentWidthPosition+1)


	}
}
