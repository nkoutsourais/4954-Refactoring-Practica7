package es.urjccode.mastercloudapps.adcs.draughts.views;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
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
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class CoordinateViewTest {

    @Mock
    PlayController playController;

    @Mock
    Console console;

    @InjectMocks
    CoordinateView coordinateView;

    @Captor
    ArgumentCaptor<String> argument;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInteractErrorCommandAndOk(){
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString(anyString()))
            .thenReturn("Loquesea\n")
            .thenReturn("32.41\n");
        Coordinate[] coordinates = coordinateView.getCoordinates(playController);
        verify(console).writeln(argument.capture());
        assertEquals(ErrorView.getMessage(Error.INCORRECT_COMMAND), argument.getValue());
        assertArrayEquals(new Coordinate[]{ new Coordinate(2, 1), new Coordinate(3, 0)}, coordinates);
    }
}