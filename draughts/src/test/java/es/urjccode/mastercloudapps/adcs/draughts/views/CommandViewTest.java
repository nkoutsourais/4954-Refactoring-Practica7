package es.urjccode.mastercloudapps.adcs.draughts.views;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class CommandViewTest {

    @Mock
    PlayController playController;

    @Mock
    Console console;

    @InjectMocks
    CommandView commandView;

    @Captor
    ArgumentCaptor<String> argument;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testInteractMoveOk(){
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(MessageView.TURN.getMessage() + ColorView.getMessage(playController.getColor()) + ": ")).thenReturn("32.41\n");
        commandView.interact(playController);
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
    }

    @Test
    public void testInteractErrorCommandErrorAndOk(){
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(MessageView.TURN.getMessage() + ColorView.getMessage(playController.getColor()) + ": "))
            .thenReturn("Loquesea\n")
            .thenReturn("32.41\n");
        commandView.interact(playController);
        verify(console).writeln(argument.capture());
        assertEquals(ErrorView.getMessage(Error.INCORRECT_COMMAND), argument.getValue());
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
    }

    @Test
    public void testInteractErrorCoordinateErrorAndOk(){
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(MessageView.TURN.getMessage() + ColorView.getMessage(playController.getColor()) + ": "))
            .thenReturn("91.87\n")
            .thenReturn("32.41\n");
        commandView.interact(playController);
        verify(console).writeln(argument.capture());
        assertEquals(ErrorView.getMessage(Error.OUT_COORDINATE), argument.getValue());
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
    }
}