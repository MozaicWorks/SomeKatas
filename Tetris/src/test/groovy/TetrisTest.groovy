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


	def "1 x 1 filled board game is game over"() {
		given:
			tetrisGame = new TetrisGame(1, 1)
			tetrisGame.filledGameCells[0][0] = true
		when:
			def gameOver = tetrisGame.isGameOver()
		then:
			assert gameOver

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


	def "1 x 2 empty board, one block falls, does not return game over"() {
		given:
			tetrisGame = new TetrisGame(1, 2)
		when:
			tetrisGame.blockFalls()
			def gameOver = tetrisGame.isGameOver()
		then:
			assert !gameOver
	}

	def "1 x 2 empty board cell, 2 blocks fall, returns game over "() {
		given:
			tetrisGame = new TetrisGame(1, 2)
		when:
			tetrisGame.blockFalls()
			tetrisGame.blockFalls()
			def gameOver = tetrisGame.isGameOver()
		then:
			assert gameOver
	}



}
