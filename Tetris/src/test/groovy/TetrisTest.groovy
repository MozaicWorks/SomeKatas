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

	def "10 x 20 empty board cell, block fall until game over, assert current level is 20"() {
		given:
			tetrisGame = new TetrisGame(10, 20)
		when:
			tetrisGame.playGame()
		then:
			assert tetrisGame.currentLevel == 20
	}



}
