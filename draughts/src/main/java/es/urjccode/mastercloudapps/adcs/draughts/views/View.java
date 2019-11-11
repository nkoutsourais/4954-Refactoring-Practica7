package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.ControllersVisitor;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;

public class View implements ControllersVisitor {

    public View(){
    }

    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        new StartView().interact(startController);
    }

    @Override
    public void visit(PlayController playController) {
        new PlayView().interact(playController);
    }

    @Override
    public void visit(ResumeController resumeController) {
        new ResumeView().interact(resumeController);
    }
}