package es.urjccode.mastercloudapps.adcs.draughts.views;

import java.lang.reflect.Method;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class GameView extends SubView {

    public void write(Controller controller) {
        final int DIMENSION = controller.getDimension();
        this.writeNumbersLine(DIMENSION);
        for (int i = 0; i < DIMENSION; i++) {
            writeAxis(i);
            for (int j = 0; j < DIMENSION; j++) {
                this.console.write(ColorView.getLetter(controller.getColor(new Coordinate(i, j))));
            }
            writeAxis(i, true);
        }
        this.writeNumbersLine(DIMENSION);
    }

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(" ");
        for (int i = 0; i < DIMENSION; i++) {
            writeAxis(i);
        }
        this.console.writeln();
    }

    private void writeAxis(int position) {
        writeAxis(position, false);
    }

    private void writeAxis(int position, boolean lineBreak) {
        try {
            Method method = this.console.getClass().getMethod(lineBreak ? "writeln" : "write", new Class[] { String.class } );
            method.invoke(this.console, (position + 1) + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}