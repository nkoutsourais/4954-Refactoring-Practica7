package es.urjccode.mastercloudapps.adcs.draughts.checkers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class CoordinatesCheckerTest {

    @Test
    public void givenCoordinatesCheckerWhenCheckThenOutCoordinate() {
        Checker checker = new CoordinatesChecker(new Coordinate(9, 1), new Coordinate(1, 2));
        assertEquals(Error.OUT_COORDINATE, checker.check());
    }

    @Test
    public void givenCoordinatesCheckerWhenCheckThenNotDiagonal() {
        Checker checker = new CoordinatesChecker(new Coordinate(1, 0), new Coordinate(2, 0));
        assertEquals(Error.NOT_DIAGONAL, checker.check());
    }

    @Test
    public void givenCoordinatesCheckerWhenCheckThenBadDistance() {
        Checker checker = new CoordinatesChecker(new Coordinate(1, 1), new Coordinate(4, 4));
        assertEquals(Error.BAD_DISTANCE, checker.check());
    }

    @Test
    public void givenCoordinatesCheckerWhenCheckThenErrorNull() {
        Checker checker = new CoordinatesChecker(new Coordinate(1, 1), new Coordinate(2, 2));
        assertNull(checker.check());
    }
}