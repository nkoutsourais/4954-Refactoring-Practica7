package es.urjccode.mastercloudapps.adcs.draughts.models;

class BoardInitialBuilder {

	private static final int BLACK_LIMIT = 2;
	private static final int WHITE_LIMIT = 5;

    private Board board;

    public BoardInitialBuilder() {
		this.board = new Board();
		for (int i = 0; i < this.board.getDimension(); i++) {
			for (int j = 0; j < this.board.getDimension(); j++) {
				Coordinate coordinate = new Coordinate(i, j);
				Piece piece = this.getInitialPiece(coordinate);
				if (piece != null) {
					this.board.put(coordinate, piece);
				}
			}
		}
	}

	private Piece getInitialPiece(Coordinate coordinate) {
		if (coordinate.isBlack()) {
			final int row = coordinate.getRow();
			Color color = null;
			if (row <= BLACK_LIMIT) {
				color = Color.BLACK;
			} else if (row >= WHITE_LIMIT) {
				color = Color.WHITE;
			}
			if (color != null) {
				return new Piece(color);
			}
		}
		return null;
    }
    
    public Board getBoard() {
        return this.board;
    }
}