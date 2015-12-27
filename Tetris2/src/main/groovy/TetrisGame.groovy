
class TetrisGame {

	int length
	int width
	boolean[][] board


	TetrisGame() {

	}

	TetrisGame(def length, def width){
		this.length = length
		this.width = width
		board = new boolean[length][width]
	}

	def gameOver() {
		board[length-1][width-1] && board[0][0]
	}

	def initializePiece() {
		board[length-1][width-1] = true
	}
}
