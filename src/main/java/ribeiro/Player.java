package ribeiro;

import ribeiro.auxiliary.*;
import ribeiro.exception.*;

public abstract class Player {
	
	private char _piece;

	public Player(char piece) throws InvalidPieceException{
		setPiece(piece);
	}

	/* ###################
	#  Public Interface  #
	################### */

	public char getPiece(){
		return _piece;
	}

	public abstract void play(State state);
	
	/* #####################
	#  Private Operations  #
	##################### */

	private void setPiece(char piece) throws InvalidPieceException{
		if(!Utilities.validPiece(piece)){
			throw new InvalidPieceException(piece);
		}
		_piece = piece;
	}

	/* ############
	#  Auxiliary  #
	############ */
}
