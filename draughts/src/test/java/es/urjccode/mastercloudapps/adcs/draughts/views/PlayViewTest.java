package es.urjccode.mastercloudapps.adcs.draughts.views;

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

@RunWith(MockitoJUnitRunner.class)
public class PlayViewTest {

    @Mock
    PlayController playController;

    @Mock
    CoordinateView CoordinateView;

    @InjectMocks
    PlayView playView;

    @Captor
    ArgumentCaptor<String> argument;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testInteractMoveOk(){
        Coordinate[] coordinates = new Coordinate[] { new Coordinate(2,1), new Coordinate(3, 0) };
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(CoordinateView.getCoordinates(playController)).thenReturn(coordinates);
        playView.interact(playController);
        verify(playController).move(coordinates[0], coordinates[1]);
    }
}