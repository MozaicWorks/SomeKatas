import spock.lang.Specification


class TetrisGameTest extends Specification {

	def "empty board 1 x 1, assert game is not over"() {
		given:
		TetrisGame tetrisGame

		when:
		tetrisGame = new TetrisGame()
		then:

		!tetrisGame.gameOver()
	}


}
