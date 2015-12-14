import spock.lang.Specification

class TetrisTest extends Specification {

	//game with empty 1 x 1 board
	// is not game over
	def "1 x 1 empty game board is not game over"() {
		given:
		def boardGame = false
		when:
		def gameOver = isGameOver(boardGame)
		then:
		assert !gameOver

	}

	def isGameOver(def boardGame) {
		return boardGame

	}

	// new game starts with empty 1 x 1 board
	// after game starts, a block falls
	// game over


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
