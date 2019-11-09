package es.urjccode.mastercloudapps.adcs.draughts.checkers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class CoordinatesCheckerTest {

    CheckerChain checker;

    public CoordinatesCheckerTest() {
        checker = new CoordinatesChecker();
    }

    @Test
    public void givenCoordinatesCheckerWhenCheckThenOutCoordinate() {
        assertEquals(Error.OUT_COORDINATE, checker.check(new Coordinate(9, 1), new Coordinate(1, 2)));
    }

    @Test
    public void givenCoordinatesCheckerWhenCheckThenNotDiagonal() {
        assertEquals(Error.NOT_DIAGONAL, checker.check(new Coordinate(1, 0), new Coordinate(2, 0)));
    }

    @Test
    public void givenCoordinatesCheckerWhenCheckThenBadDistance() {
        assertEquals(Error.BAD_DISTANCE, checker.check(new Coordinate(1, 1), new Coordinate(4, 4)));
    }

    @Test
    public void givenCoordinatesCheckerWhenCheckThenErrorNull() {
        assertNull(checker.check(new Coordinate(1, 1), new Coordinate(2, 2)));
    }
}