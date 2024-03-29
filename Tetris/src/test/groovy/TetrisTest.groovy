import spock.lang.Specification

class TetrisTest extends Specification {

	TetrisGame tetrisGame

	def "1 x 1 empty game board is not game over"() {
		given:
			tetrisGame = new TetrisGame(1, 1)
		when:
			def gameOver = tetrisGame.isGameOver()
		then:
			assert !gameOver
	}


	def "1 x 1 empty board game, one piece is initialized on table, returns game over"() {
		given:
			tetrisGame = new TetrisGame(1, 1)

		when:
		tetrisGame.generateCurrentPiece(TetrisPieceType.OTHER)
		def gameOver = tetrisGame.isGameOver()

		then:
			assert gameOver
	}


	def "2 x 1 empty board, one block falls, does not return game over"() {
		given:
			tetrisGame = new TetrisGame(2, 1)
		when:
			tetrisGame.blockFalls()
			def gameOver = tetrisGame.isGameOver()
		then:
			assert !gameOver
	}

	def "2 x 1 empty board cell, 2 blocks fall, returns game over "() {
		given:
			tetrisGame = new TetrisGame(2, 1)

		when:
		tetrisGame.blockFalls()
		tetrisGame.blockFalls()
		def gameOver = tetrisGame.isGameOver()

		then:
			assert gameOver
	}

	def "20 x 1 empty board cell, block fall until game over, assert current level is 20"() {
		given:
			tetrisGame = new TetrisGame(20, 1)
		when:
			tetrisGame.playGame()
		then:
			assert tetrisGame.tetrisBoard.getFilledLevel() == 20
	}


	def "2 x 1 empty board cell, block is initialized and falls one cell, assert filledBoardCell[0][0] is 1"() {
		given:
		tetrisGame = new TetrisGame(2, 1)
		when:
		tetrisGame.generateCurrentPiece(TetrisPieceType.OTHER)
		tetrisGame.fallsOneCell()
		then:
		assert tetrisGame.isCellFromGivenPositionFilled(0, 0)
	}


	def "2 x 1 empty board cell, block falls one cell, assert filledBoardCell[1][0] is false"() {
		given:
		tetrisGame = new TetrisGame(2, 1)
		when:
		tetrisGame.generateCurrentPiece(TetrisPieceType.OTHER)
		tetrisGame.fallsOneCell()
		then:
		assert !tetrisGame.isCellFromGivenPositionFilled(1,0)
	}


	def "1 x 2 empty game board is not game over"() {
		given:
		tetrisGame = new TetrisGame(1, 2)

		when:
		def gameOver = tetrisGame.isGameOver()
		then:
		assert !gameOver
	}

	def "1 x 2 empty board game, one block falls returns game over"() {
		given:
		tetrisGame = new TetrisGame(1, 2)
		when:
		tetrisGame.blockFalls()
		def gameOver = tetrisGame.isGameOver()
		then:
		assert gameOver
	}

	def "20 x 10 empty board cell, block fall until game over, assert current level is 20"() {
		given:
		tetrisGame = new TetrisGame(20, 10)
		when:
		tetrisGame.playGame()
		then:
		assert tetrisGame.tetrisBoard.filledLevel == 20
	}

	def "1 x 2 board cell, one block falls left, assert filledBoardCells[0][1] is 1" () {
		given:
		tetrisGame = new TetrisGame(1, 2)
		tetrisGame.generateCurrentPiece(TetrisPieceType.OTHER)

		when:
		tetrisGame.fallsOneCell()
		tetrisGame.moveBlockToLeft()
		def result = tetrisGame.isCellFromGivenPositionFilled(0, 0)
		then:
		assert result
	}

	def "1 x 2 board cell, one block falls right, assert filledBoardCells[0][1] is 1" () {
		given:
		tetrisGame = new TetrisGame(1, 2)
		tetrisGame.generateCurrentPiece(TetrisPieceType.OTHER)

		when:
		tetrisGame.fallsOneCell()
		tetrisGame.moveBlockToRight()
		def result = tetrisGame.isCellFromGivenPositionFilled(0, 1)

		then:
		assert result
	}

	def "20 x 10 board, I piece appears on screen, assert current length position is boardLength - 1"() {
		given:
		tetrisGame = new TetrisGame(20, 10)

		when:
		tetrisGame.generateCurrentPiece(TetrisPieceType.I)

		then:
		assert tetrisGame.tetrisBoard.boardLength -1  == tetrisGame.tetrisPiece.currentLengthPosition
	}



	def "20 x 10 board, I piece appears on screen, assert filledBoardCells[boardLength-1][width/2 +3] is 1"() {
		given:
		tetrisGame = new TetrisGame(20, 10)

		when:
		tetrisGame.generateCurrentPiece(TetrisPieceType.I)
		int lengthPos = tetrisGame.tetrisBoard.boardLength - 1
		int widthPos = tetrisGame.tetrisBoard.boardWidth/2 +3
		then:
		assert tetrisGame.isCellFromGivenPositionFilled(lengthPos, widthPos)
	}


	def "20 x 10 board, I piece appears on screen, assert filledBoardCells[boardLength-1][width] is 1"() {
		given:
		tetrisGame = new TetrisGame(20, 10)

		when:
		tetrisGame.generateCurrentPiece(TetrisPieceType.I)
		int lengthPos = tetrisGame.tetrisBoard.boardLength - 1
		int widthPos = tetrisGame.tetrisBoard.boardWidth/2
		then:
		assert tetrisGame.isCellFromGivenPositionFilled(lengthPos, widthPos)
	}

	def "20 x 10 board, I piece appears on screen, assert filledBoardCells[boardLength-2][witdth/2] is 1"() {
		given:
		tetrisGame = new TetrisGame(20, 10)

		when:
		tetrisGame.generateCurrentPiece(TetrisPieceType.I)
		int lengthPos = tetrisGame.tetrisBoard.boardLength - 1
		int widthPos = tetrisGame.tetrisBoard.boardWidth/2 + 1
		then:
		assert tetrisGame.isCellFromGivenPositionFilled(lengthPos, widthPos)
	}

	def "20 x 10 board, I piece appears on screen, assert filledBoardCells[boardLength-1][witdth/2] is 1"() {
		given:
		tetrisGame = new TetrisGame(20, 10)

		when:
		tetrisGame.generateCurrentPiece(TetrisPieceType.I)
		int lengthPos = tetrisGame.tetrisBoard.boardLength - 1
		int widthPos = tetrisGame.tetrisBoard.boardWidth/2 + 2

		then:
		assert tetrisGame.isCellFromGivenPositionFilled(lengthPos, widthPos)
	}

	def "20 x 10 board, J piece appears on screen, assert filledBoardCells[boardLength-2][witdth/2 +1] is 1"() {
		given:
		tetrisGame = new TetrisGame(20, 10)

		when:
		tetrisGame.generateCurrentPiece(TetrisPieceType.J)
		int lengthPos = tetrisGame.tetrisBoard.boardLength - 2
		int widthPos = tetrisGame.tetrisBoard.boardWidth/2 +1

		then:
		assert tetrisGame.isCellFromGivenPositionFilled(lengthPos, widthPos)
	}

	def "20 x 10 board, J piece appears on screen, assert filledBoardCells[boardLength-2][witdth/2 +2] is 1"() {
		given:
		tetrisGame = new TetrisGame(20, 10)

		when:
		tetrisGame.generateCurrentPiece(TetrisPieceType.J)
		int lengthPos = tetrisGame.tetrisBoard.boardLength - 2
		int widthPos = tetrisGame.tetrisBoard.boardWidth/2+1

		then:
		assert tetrisGame.isCellFromGivenPositionFilled(lengthPos, widthPos)
	}


	def "20 x 10 board, J piece appears on screen, assert filledBoardCells[boardLength-1][witdth/2] is 1"() {
		given:
		tetrisGame = new TetrisGame(20, 10)

		when:
		tetrisGame.generateCurrentPiece(TetrisPieceType.J)
		int lengthPos = tetrisGame.tetrisBoard.boardLength - 1
		int widthPos = tetrisGame.tetrisBoard.boardWidth/2

		then:
		assert tetrisGame.isCellFromGivenPositionFilled(lengthPos, widthPos)
	}


	def "20 x 10 board, J piece appears on screen, assert filledBoardCells[boardLength-2][witdth/2] is 1"() {
		given:
		tetrisGame = new TetrisGame(20, 10)

		when:
		tetrisGame.generateCurrentPiece(TetrisPieceType.J)
		int lengthPos = tetrisGame.tetrisBoard.boardLength - 2
		int widthPos = tetrisGame.tetrisBoard.boardWidth/2

		then:
		assert tetrisGame.isCellFromGivenPositionFilled(lengthPos, widthPos)
	}





}
