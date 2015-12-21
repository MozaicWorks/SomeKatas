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


	def "1 x 1 empty board game, one block falls returns game over"() {
		given:
			tetrisGame = new TetrisGame(1, 1)
		when:
			tetrisGame.blockFalls()
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
			assert tetrisGame.filledLevel == 20
	}

	def "1 x 1 empty board cell, block falls one cell at a time, assert filledBoardCell[0][0] is true"() {
		given:
			tetrisGame = new TetrisGame(1, 1)
		when:
			tetrisGame.fallsOneCell()
		then:
			assert tetrisGame.filledBoardCells[0][0]
	}

	def "2 x 1 empty board cell, block falls one cell, assert filledBoardCell[1][0] is true"() {
		given:
		tetrisGame = new TetrisGame(2, 1)
		when:
		tetrisGame.fallsOneCell()
		then:
		assert tetrisGame.filledBoardCells[1][0]
	}


	def "2 x 1 empty board cell, block falls one cell, assert filledBoardCell[0][0] is false"() {
		given:
		tetrisGame = new TetrisGame(2, 1)
		when:
		tetrisGame.fallsOneCell()
		then:
		assert tetrisGame.filledBoardCells[1][0]
	}

	def "2 x 1 empty board cell, block current position is [1][0], it falls another cell, assert filledBoardCell[0][0] is true"() {
		given:
		tetrisGame = new TetrisGame(2, 1)
		tetrisGame.currentLengthPosition = 1
		when:
		tetrisGame.fallsOneCell()
		then:
		assert tetrisGame.filledBoardCells[0][0]
	}


	def "2 x 1 empty board cell, block current position is [1][0], it falls another cell, assert filledBoardCell[1][0] is false"() {
		given:
		tetrisGame = new TetrisGame(2, 1)
		tetrisGame.currentLengthPosition = 1
		when:
		tetrisGame.fallsOneCell()
		then:
		assert !tetrisGame.filledBoardCells[1][0]
	}

	def "1 x 2 empty game board is not game over"() {
		given:
		tetrisGame = new TetrisGame(1, 2)
		when:
		def gameOver = tetrisGame.isGameOver()
		then:
		assert !gameOver
	}


}
