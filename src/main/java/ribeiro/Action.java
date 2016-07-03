package ribeiro;

import ribeiro.auxiliary.*;
import ribeiro.exception.*;

public class Action{
	
	int _position;
	int _line, _collumn;
	char _piece;

	public Action(char piece, int position) throws InvalidPieceException, InvalidPositionException{
		setPiece(piece);
		setPosition(position);
	}

	@Deprecated
	private Action(char piece, int line, int collumn) throws InvalidPieceException, InvalidCoordinatesException {
		setPiece(piece);
		setCoordinates(line, collumn);
	}

	/* ###################
	#  Public Interface  #
	################### */
	
	public char getPiece(){
		return _piece;
	}

	public int getPosition(){
		return _position;
	}

	public int[] getCoordinates(){
		int[] coordinates = new int[2];
		coordinates[0] = _line;
		coordinates[1] = _collumn;
		return coordinates;
	}

	public int getLine(){
		return _line;
	}

	public int getCollumn(){
		return _collumn;
	}

	@Override
	public boolean equals(Object obj){
		boolean isAction = obj instanceof Action;
		Action action2 = (Action)obj;

		boolean equal = action2.getPosition()==getPosition() && action2.getPiece()==getPiece();
		
		return isAction && equal;

	}

	/* #####################
	#  Private Operations  #
	##################### */

	private void setPiece(char piece) throws InvalidPieceException{
		if(!Utilities.validPiece(piece)){
			throw new InvalidPieceException(piece);
		}
		_piece = piece;
	}

	private void setPosition(int position) throws InvalidPositionException{
		if(!Utilities.validPosition(position)){
			throw new InvalidPositionException(position);
		}

		int[] coordinates = Utilities.vectorToMatrix(position);
		_line = coordinates[0];
		_collumn = coordinates[1];
		_position = position;
		
	}

	private void setCoordinates(int line, int collumn) throws InvalidCoordinatesException{
		if(!Utilities.validCoordinates(line, collumn)){
			throw new InvalidCoordinatesException(line, collumn);
		}
		_position = Utilities.matrixToVector(line, collumn);
		_line = line;
		_collumn = collumn;
	}

	/* ############
	#  Auxiliary  #
	############ */



}
