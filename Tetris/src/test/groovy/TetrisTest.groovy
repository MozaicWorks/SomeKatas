import spock.lang.Specification

class TetrisTest extends Specification {


	 TetrisGame tetrisGame

	def setup() {
		tetrisGame = new TetrisGame();
	}

	//game with empty 1 x 1 board
	// is not game over
	def "1 x 1 empty game board is not game over"() {
		when:
			def gameOver = tetrisGame.isGameOver()
		then:
			assert !gameOver

	}



	//game with filled 1 x 1 board
	// is game over
	def "1 x 1 filled board game is game over"() {
		given:
			tetrisGame.boardGame = true
		when:
			def gameOver = tetrisGame.isGameOver()
		then:
			assert gameOver

	}


	// new game starts with empty 1 x 1 board
	// after game starts, a block falls
	// game over
	def "1 x 1 empty board game, one block falls returns game over"() {
		when:
			tetrisGame.fillBoardGame()
			def gameOver = tetrisGame.isGameOver()
		then:
			assert gameOver
	}




// new game starts with empty 1 x 2 board
	// after game starts, a block falls OK
	// then the block falls one more
	// game over

	// new game starts with empty 10 x 20 board
	// after game starts, a block falls OK
	// then the block falls one more
	// ... until down
	// another block falls
	// ... until down
	// etc.
	// game over


}
