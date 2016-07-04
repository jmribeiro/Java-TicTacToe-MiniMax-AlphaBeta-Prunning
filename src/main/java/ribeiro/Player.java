package ribeiro;

import ribeiro.auxiliary.*;
import ribeiro.exception.*;
import ribeiro.userinterface.UserInterface;

public abstract class Player {
	
	private char _piece;
	protected UserInterface _userInterface;
	
	public Player(char piece) throws InvalidPieceException{
		setPiece(piece);
	}

	/* ###################
	#  Public Interface  #
	################### */

	public char getPiece(){
		return _piece;
	}
	
	public void setUserInterface(UserInterface userInterface) {
		_userInterface = userInterface;
	}

	public abstract void play(State state);
	public abstract void userInterfaceCallback(String input);
	
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
