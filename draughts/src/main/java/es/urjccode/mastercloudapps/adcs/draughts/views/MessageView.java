package es.urjccode.mastercloudapps.adcs.draughts.views;

public enum MessageView {
    RESUME("¿Queréis jugar otra"),
    TITLE("Las Damas!!!"), 
    TURN("Mueven las "), 
    FINAL("Derrota!!! No puedes mover tus fichas!!!");

    private String message;

    private MessageView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}