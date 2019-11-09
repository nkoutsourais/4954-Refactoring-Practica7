package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class CommandView extends SubView {

    public CommandView() {
        super();
    }

    public void interact(PlayController playController) {
        GameView gameView = new GameView();
        Error error = null;
        do {
            Coordinate[] coordinates = getCoordinates(playController);
            error = playController.move(coordinates[0], coordinates[1]);
            if (error != null) {
                console.writeln(ErrorView.getMessage(error));
            }
            gameView.write(playController);
        } while (error != null);
        if (playController.isBlocked()) {
            this.console.write(MessageView.FINAL.getMessage());
        }
    }

    private Coordinate[] getCoordinates(PlayController playController) {
        Error error;
        Coordinate[] coordinates = null;
        do {
            error = null;
            String title = MessageView.TURN.getMessage() + ColorView.getMessage(playController.getColor()) + ": ";
            try {
                String command = this.console.readString(title);
                coordinates = getCoordinates(command);
                if (!coordinates[0].isValid() || !coordinates[1].isValid()) {
                    error = Error.OUT_COORDINATE;
                }
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