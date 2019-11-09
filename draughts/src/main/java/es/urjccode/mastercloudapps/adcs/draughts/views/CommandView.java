package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class CommandView extends SubView {

    public CommandView() {
        super();
    }

    public void interact(PlayController playController) {
        Error error = null;
        GameView gameView = new GameView();
        do {
            String command = this.console.readString(MessageView.TURN.getMessage() + ColorView.getMessage(playController.getColor()) + ": ");
            int origin = Integer.parseInt(command.substring(0, 2));
            int target = Integer.parseInt(command.substring(3, 5));
            error = playController.move(new Coordinate(origin / 10 - 1, origin % 10 - 1), new Coordinate(target / 10 - 1, target % 10 - 1));
            if (error != null) {
                console.writeln(ErrorView.getMessage(error));
            }
            gameView.write(playController);
        } while (error != null);
        if (playController.isBlocked()) {
            this.console.write(MessageView.FINAL.getMessage());
        }
    }
}