package es.urjccode.mastercloudapps.adcs.draughts.checkers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;

class PieceChecker extends CheckerChain {

    private static final int DISTANCE_DIAGONAL_FOR_EAT = 2;

    Game game;

    PieceChecker(Game game) {
        this.game = game;
    }

    @Override
    public Error check(Coordinate origin, Coordinate target) {
        Piece piece = this.game.getPiece(origin);
		if (!piece.isAdvanced(origin, target)) {
			return Error.NOT_ADVANCED;
        }
        if (origin.diagonalDistance(target) == DISTANCE_DIAGONAL_FOR_EAT) {
			Coordinate between = origin.betweenDiagonal(target);
			if (this.game.getPiece(between) == null) {
				return Error.EATING_EMPTY;
			}
        }
        return checkNext(origin, target);
    }
}