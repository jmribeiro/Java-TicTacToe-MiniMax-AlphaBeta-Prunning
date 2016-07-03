package ribeiro;

import ribeiro.auxiliary.*;
import ribeiro.exception.*;

public class ArtificialIntelligence extends Player{
	
	public ArtificialIntelligence(char piece) throws InvalidPieceException{
		super(piece);
	}

	/* ###################
	#  Public Interface  #
	################### */
	
	public Action getNextAction(State state){
		return null;
	}

	/* #####################
	#  Private Operations  #
	##################### */

	/* ############
	#  Auxiliary  #
	############ */
}
