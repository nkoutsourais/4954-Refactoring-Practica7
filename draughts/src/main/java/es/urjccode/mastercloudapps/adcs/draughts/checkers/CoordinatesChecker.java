package es.urjccode.mastercloudapps.adcs.draughts.checkers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class CoordinatesChecker implements Checker {

    private final Coordinate origin;
    private final Coordinate target;

    public CoordinatesChecker(Coordinate origin, Coordinate target) {
        assert origin != null && target != null;
        this.origin = origin;
        this.target = target;
    }

    @Override
    public Error check() {
        Error error = null;
        if (!origin.isValid() || !target.isValid()) {
            error = Error.OUT_COORDINATE;
        } else if (!origin.isDiagonal(target)) {
            error = Error.NOT_DIAGONAL;
        } else if (origin.diagonalDistance(target) >= 3) {
            error = Error.BAD_DISTANCE;
        }
        return error;
    }
}