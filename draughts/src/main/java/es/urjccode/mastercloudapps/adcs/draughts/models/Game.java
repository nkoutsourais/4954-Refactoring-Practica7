package es.urjccode.mastercloudapps.adcs.draughts.models;

import es.urjccode.mastercloudapps.adcs.draughts.checkers.BoardChecker;
import es.urjccode.mastercloudapps.adcs.draughts.checkers.CheckerChain;
import es.urjccode.mastercloudapps.adcs.draughts.checkers.PieceChecker;

public class Game {

	private Board board;

	private Turn turn;

	private CheckerChain checker;

	public Game() {
		this.turn = new Turn();
		this.board = new BoardInitialBuilder().getBoard();
		this.checker = new BoardChecker(this);
		this.checker.linkWith(new PieceChecker(this));
	}

	public Error move(Coordinate origin, Coordinate target) {
		assert origin != null && target != null;
		Error error = this.checker.check(origin, target);
		if(error != null)
			return error;
		this.board.move(origin, target);
		this.turn.change();
		return null;
	}

	public Color getColor(Coordinate coordinate) {
		return this.board.getColor(coordinate);
	}

	@Override
	public String toString() {
		return this.board + "\n" + this.turn;
	}

	public Color getColor() {
		return this.turn.getColor();
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.board.getPiece(coordinate);
	}

	public boolean isBlocked() {
		return this.board.getPieces(this.turn.getColor()).isEmpty();
	}

	public int getDimension() {
		return this.board.getDimension();
	}

	public boolean isEmpty(Coordinate coordinate) {
        return this.board.isEmpty(coordinate);
    }
}