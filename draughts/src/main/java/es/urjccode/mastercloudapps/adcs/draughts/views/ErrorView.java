package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class ErrorView {

	static final String[] MESSAGES = { 
		"Error!!! No es una coordenada del tablero", 
		"Error!!! No hay ficha que mover",
		"Error!!! No es una de tus fichas", 
        "Error!!! No vas en diagonal", 
        "Error!!! No respetas la distancia",
		"Error!!! No está vacío el destino",
        "Error!!! No avanzas", 
        "Error!!! No comes contrarias",
        "Error!!! No te entiendo: <d><d>{.<d><d>}[0-2]"
    };

	public static String getMessage(Error error) {
		return ErrorView.MESSAGES[error.ordinal()];
	}
}