package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.models.Color;

class ColorView {

    static final String[] MESSAGES = { "Blancas", "Negras" };
    static final String[] COLORS = new String[] { "b", "n" };

    public static String getMessage(Color color) {
        return ColorView.MESSAGES[color.ordinal()];
    }

    public static String getLetter(Color color) {
        return color == null ? " " : ColorView.COLORS[color.ordinal()];
    }
}