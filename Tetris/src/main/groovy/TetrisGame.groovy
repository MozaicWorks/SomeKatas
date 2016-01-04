class TetrisGame {

	TetrisPiece tetrisPiece
	TetrisBoard tetrisBoard

	TetrisGame(def boardLength, def boardWidth) {
		tetrisBoard = new TetrisBoard(boardLength, boardWidth)
	}

	def generateCurrentPiece(TetrisPieceType type) {
		tetrisPiece = type.createPiece(tetrisBoard.boardLength-1, tetrisBoard.boardWidth/2)
		initializeCurrentPieceOnBoard()

	}

	def initializeCurrentPieceOnBoard() {
		if(tetrisPiece.currentLengthPosition - tetrisPiece.length <= tetrisBoard.filledLevel) {
			tetrisBoard.filledLevel++
		}
		for(int i = 0; i < tetrisPiece.length; i++) {
			for (int j = 0; j < tetrisPiece.width; j++) {
				tetrisBoard.filledBoardCells[tetrisPiece.currentLengthPosition-i][j+tetrisPiece.currentWidthPosition] \
				 = tetrisPiece.shape[i][j]
			}
		}
	}



	def blockFalls(TetrisPieceType type = TetrisPieceType.OTHER) {
		if(!isGameOver()) {
			generateCurrentPiece(type)
			while (canFall()) {
				fallsOneCell()
			}
		}
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
			markCurrentPositionAsUnfilled()
			tetrisPiece.currentLengthPosition --;
			markCurrentPositionAsFilled()
			if(tetrisPiece.currentLengthPosition - tetrisPiece.length == tetrisBoard.filledLevel) {
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


}
