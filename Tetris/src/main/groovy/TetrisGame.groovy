class TetrisGame {

	TetrisPiece tetrisPiece
	TetrisBoard tetrisBoard



	TetrisGame(def boardLength, def boardWidth) {
		tetrisBoard = new TetrisBoard(boardLength, boardWidth)
		generateCurrentPiece()
	}

	def generateCurrentPiece() {
		tetrisPiece = new IPiece(tetrisBoard.boardLength, tetrisBoard.boardWidth/2)
	}

	def displayCurrentPiece() {
		for(int i = 0; i < tetrisPiece.length; i++) {
			for (int j = 0; j < tetrisPiece.width; j++) {
				tetrisBoard.filledBoardCells[tetrisPiece.currentLengthPosition-i][j+tetrisPiece.currentWidthPosition] \
				 = tetrisPiece.shape[i][j]
			}
		}
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
				markCurrentPositionAsUnfilled()
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

	private void markCurrentPositionAsUnfilled() {
		tetrisBoard.markPositionAsUnFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition)
	}

	private void markCurrentPositionAsFilled() {
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition)
	}

	def isCellFromGivenPositionFilled(int givenLength, int givenWidth) {
		return tetrisBoard.filledBoardCells[givenLength][givenWidth]
	}

	def moveBlockToLeft() {
		if(canMoveLeft()) {
			markCurrentPositionAsUnfilled()
			tetrisPiece.currentWidthPosition--
			markCurrentPositionAsFilled()
		}
	}

	private boolean canMoveLeft() {
		tetrisPiece.currentWidthPosition > 0
	}

	def moveBlockToRight() {
		if(canMoveRight()) {
			markCurrentPositionAsUnfilled()
			tetrisPiece.currentWidthPosition++
			markCurrentPositionAsFilled()
		}
	}

	private boolean canMoveRight() {
		tetrisPiece.currentWidthPosition <  tetrisBoard.boardWidth-1
	}


	def initializeIPiece() {
		tetrisPiece.currentLengthPosition --
		displayCurrentPiece()
	}

	def initializeJPiece() {
		tetrisPiece.currentLengthPosition --
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition-1)
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition)
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition, tetrisPiece.currentWidthPosition+1)
		tetrisBoard.markPositionAsFilled(tetrisPiece.currentLengthPosition-1, tetrisPiece.currentWidthPosition+1)
	}
}
