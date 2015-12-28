import spock.lang.Specification


class TetrisGameTest extends Specification {


	def "assert game is not over"() {
		given:
		TetrisGame tetrisGame = new TetrisGame(1,1)

		when:
		def gameOver = tetrisGame.gameOver()

		then:
		!gameOver
	}

	def "empty board 1 x 1, initialize one piece, assert game is over"() {
		given:
		TetrisGame tetrisGame

		when:
		tetrisGame = new TetrisGame(1,1)
		tetrisGame.initializePiece()
		def gameOver = tetrisGame.gameOver()

		then:
		gameOver

	}

	def "empty board 2 x 1, initialize one piece, assert game is not over"() {
		given:
		TetrisGame tetrisGame

		when:
		tetrisGame = new TetrisGame(2, 1)
		tetrisGame.initializePiece()
		def gameOver = tetrisGame.gameOver()

		then:
		!gameOver
	}
}
