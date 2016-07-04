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

	/* ###################
	#  Public Interface  #
	################### */
	
	public char getPiece(){
		return _piece;
	}

	public int getPosition(){
		return _position;
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
		_position = position;
		
	}


	/* ############
	#  Auxiliary  #
	############ */



}
