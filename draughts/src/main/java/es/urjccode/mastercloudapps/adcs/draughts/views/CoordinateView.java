package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.checkers.Checker;
import es.urjccode.mastercloudapps.adcs.draughts.checkers.CoordinatesChecker;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

class CoordinateView extends SubView {

    public Coordinate[] getCoordinates(PlayController playController) {
        Error error;
        Coordinate[] coordinates = null;
        do {
            String title = MessageView.TURN.getMessage() + ColorView.getMessage(playController.getColor()) + ": ";
            try {
                String command = this.console.readString(title);
                coordinates = getCoordinates(command);
                Checker coordinatesChecker = new CoordinatesChecker(coordinates[0], coordinates[1]);
                error = coordinatesChecker.check();
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
        int originPos = Integer.parseInt(positions[0]);
        int targetPos = Integer.parseInt(positions[1]);
        Coordinate origin = new Coordinate(originPos / 10 - 1, originPos % 10 - 1);
        Coordinate target = new Coordinate(targetPos / 10 - 1, targetPos % 10 - 1);
        return new Coordinate[] { origin, target };
    }
}