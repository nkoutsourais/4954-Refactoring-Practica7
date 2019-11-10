package es.urjccode.mastercloudapps.adcs.draughts.checkers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;

class BoardChecker extends CheckerChain {

    Game game;

    BoardChecker(Game game) {
        this.game = game;
    }

    @Override
    public Error check(Coordinate origin, Coordinate target) {
        if (this.game.isEmpty(origin)) {
			return Error.EMPTY_ORIGIN;
		}
		Color color = this.game.getColor(origin);
		if (this.game.getColor() != color) {
			return Error.OPPOSITE_PIECE;
		}
		if (!this.game.isEmpty(target)) {
			return Error.NOT_EMPTY_TARGET;
        }
        return checkNext(origin, target);
    }
}