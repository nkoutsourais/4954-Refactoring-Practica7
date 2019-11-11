package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.checkers.CheckerChain;
import es.urjccode.mastercloudapps.adcs.draughts.checkers.CoordinatesChecker;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

class CoordinateView extends SubView {

    CheckerChain coordinatesChecker;

    public CoordinateView() {
        coordinatesChecker = new CoordinatesChecker();
    }

    public Coordinate[] getCoordinates(PlayController playController) {
        Error error;
        Coordinate[] coordinates = null;
        do {
            String title = MessageView.TURN.getMessage() + ColorView.getMessage(playController.getColor()) + ": ";
            try {
                String command = this.console.readString(title);
                coordinates = getCoordinates(command);
                error = coordinatesChecker.check(coordinates[0], coordinates[1]);
            } catch (Exception ex) {
                error = Error.INCORRECT_COMMAND;
            }
            if (error != null) {
                console.writeln(ErrorView.getMessage(error));
            }
        } while (error != null);
        return coordinates;
    }

    private Coordinate[] getCoordinates(String command) {
        String[] positions = command.trim().split("\\.");
        return new Coordinate[] { getCoordinate(positions[0]), getCoordinate(positions[1]) };
    }

    private Coordinate getCoordinate(String command) {
        int position = Integer.parseInt(command);
        return new Coordinate(position / 10 - 1, position % 10 - 1);
    }
}