package es.urjccode.mastercloudapps.adcs.draughts.checkers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public abstract class CheckerChain {

    private CheckerChain next;

    public CheckerChain linkWith(CheckerChain next) {
        this.next = next;
        return next;
    }

    protected Error checkNext(Coordinate origin, Coordinate target) {
        if (next == null) {
            return null;
        }
        return next.check(origin, target);
    }

    public abstract Error check(Coordinate origin, Coordinate target);
}