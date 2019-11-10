package es.urjccode.mastercloudapps.adcs.draughts.checkers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;

public class GameValidator {

    public static CheckerChain getChecker(Game game) {
        CheckerChain checker = new BoardChecker(game);
        checker.linkWith(new PieceChecker(game));
        return checker;
    }
}