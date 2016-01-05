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
		public LPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new LPiece(currentLengthPos, currentWidthPos)
		}
	},
	O {
		public OPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new OPiece(currentLengthPos, currentWidthPos)
		}
	},
	S {
		public SPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new SPiece(currentLengthPos, currentWidthPos)
		}
	},
	T {
		public TPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new TPiece(currentLengthPos, currentWidthPos)
		}
	},
	Z {
		public ZPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new ZPiece(currentLengthPos, currentWidthPos)
		}
	},

	OTHER {
		public TetrisPiece createPiece(def currentLengthPos, def currentWidthPos) {
			return new TetrisPiece(currentLengthPos, currentWidthPos)
		}
	}


	public abstract TetrisPiece createPiece(def currentLengthPos, def currentWidthPos)
}