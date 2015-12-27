import spock.lang.Specification


class TetrisGameTest extends Specification {


	def "assert game is not over"() {
		given:
		TetrisGame tetrisGame

		when:
		tetrisGame = new TetrisGame()

		then:
		!tetrisGame.gameOver()
	}

	def "empty board 1 x 1, initialize one piece, assert game is over"() {
		given:
		TetrisGame tetrisGame

		when:
		tetrisGame = new TetrisGame()
		tetrisGame.initializePiece()

		then:
		tetrisGame.gameOver()
	}


}
