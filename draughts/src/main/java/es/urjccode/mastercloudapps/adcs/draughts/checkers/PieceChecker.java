package es.urjccode.mastercloudapps.adcs.draughts.checkers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;

public class PieceChecker extends CheckerChain {

    Game game;

    public PieceChecker(Game game) {
        this.game = game;
    }

    @Override
    public Error check(Coordinate origin, Coordinate target) {
        Piece piece = this.game.getPiece(origin);
		if (!piece.isAdvanced(origin, target)) {
			return Error.NOT_ADVANCED;
        }
        if (origin.diagonalDistance(target) == 2) {
			Coordinate between = origin.betweenDiagonal(target);
			if (this.game.getPiece(between) == null) {
				return Error.EATING_EMPTY;
			}
        }
        return checkNext(origin, target);
    }
}