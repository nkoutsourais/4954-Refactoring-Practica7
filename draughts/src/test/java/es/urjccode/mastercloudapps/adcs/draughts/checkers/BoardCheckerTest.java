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
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;

@RunWith(MockitoJUnitRunner.class)
public class BoardCheckerTest {

    @Mock
    Game game;

    @InjectMocks
    BoardChecker checker;

    @Test
    public void givenBoardCheckerWhenGameIsEmptyOriginThenErrorEmptyOrigin() {
        when(game.isEmpty(any())).thenReturn(true);
        assertEquals(Error.EMPTY_ORIGIN, checker.check(null, null));
    }

    @Test
    public void givenBoardCheckerWhenMoveOppositePieceThenErrorOppositePiece() {
        when(game.isEmpty(any())).thenReturn(false);
        when(game.getColor(any())).thenReturn(Color.BLACK);
        when(game.getColor()).thenReturn(Color.WHITE);
        assertEquals(Error.OPPOSITE_PIECE, checker.check(null, null));
    }

    @Test
    public void givenBoardCheckerWhenGameIsEmptyTargetThenErrorEmptyTarget() {
        when(game.isEmpty(any())).thenReturn(false);
        when(game.getColor(any())).thenReturn(Color.BLACK);
        when(game.getColor()).thenReturn(Color.BLACK);
        assertEquals(Error.NOT_EMPTY_TARGET, checker.check(null, null));
    }

    @Test
    public void givenBoardCheckerWhenGameIsOkThenOk() {
        when(game.isEmpty(any())).thenReturn(false).thenReturn(true);
        when(game.getColor(any())).thenReturn(Color.BLACK);
        when(game.getColor()).thenReturn(Color.BLACK);
        assertNull(checker.check(null, null));
    }
}