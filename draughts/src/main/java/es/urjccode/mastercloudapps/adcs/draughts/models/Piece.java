package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Piece {

	private Color color;

	public Piece(Color color){
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public boolean isAdvanced(Coordinate origin, Coordinate target) {
		int difference = origin.getRow() - target.getRow();
		return color == Color.WHITE ? difference > 0 : difference < 0;
	}
}