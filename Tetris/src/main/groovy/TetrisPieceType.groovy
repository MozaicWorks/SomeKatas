enum TetrisPieceType {
	I {
		public IPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new IPiece(currentLengthPos, currentWidthPos)
		}
	},
	J {
		public JPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new JPiece(currentLengthPos, currentWidthPos)
		}
	},
	L {
		public JPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new JPiece(currentLengthPos, currentWidthPos)
		}
	},
	O {
		public JPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new JPiece(currentLengthPos, currentWidthPos)
		}
	},
	S {
		public JPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new JPiece(currentLengthPos, currentWidthPos)
		}
	},
	T {
		public JPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new JPiece(currentLengthPos, currentWidthPos)
		}
	},
	Z {
		public JPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new JPiece(currentLengthPos, currentWidthPos)
		}
	},

	OTHER {
		public TetrisPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new TetrisPiece(currentLengthPos, currentWidthPos)
		}
	}


	public abstract TetrisPiece createPiece(def currentLengthPos, def currentWidthPos)
}