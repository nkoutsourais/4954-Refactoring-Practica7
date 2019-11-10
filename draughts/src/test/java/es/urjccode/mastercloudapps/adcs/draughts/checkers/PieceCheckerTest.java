package es.urjccode.mastercloudapps.adcs.draughts.checkers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;

@RunWith(MockitoJUnitRunner.class)
public class PieceCheckerTest {

    @Mock
    Game game;

    @InjectMocks
    PieceChecker checker;

    @Test
    public void givenPieceCheckerWhenPieceNotAdvanceThenErrorNotAdvanced() {
        when(game.getPiece(any()))
            .thenReturn(new Piece(Color.BLACK))
            .thenReturn(new Piece(Color.WHITE));
        assertEquals(Error.NOT_ADVANCED, checker.check(new Coordinate(5, 6), new Coordinate(4, 7)));
        assertEquals(Error.NOT_ADVANCED, checker.check(new Coordinate(4, 7), new Coordinate(5, 6)));
    }

    @Test
    public void givenPieceCheckerWhenDiagonalEatEmptyThenErrorEatingEmpty() {
        when(game.getPiece(any()))
            .thenReturn(new Piece(Color.WHITE))
            .thenReturn(null);
        assertEquals(Error.EATING_EMPTY, checker.check(new Coordinate(5, 4), new Coordinate(3, 2)));
    }

    @Test
    public void givenPieceCheckerWhenGameIsOkThenOk() {
        when(game.getPiece(any())).thenReturn(new Piece(Color.WHITE));
        assertNull(checker.check(new Coordinate(5, 4), new Coordinate(4, 3)));
    }
}