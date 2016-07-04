package ribeiro;

import ribeiro.exception.*;
import ribeiro.userinterface.UserInterface;

import java.util.*;

public class ArtificialIntelligence extends Player{
	
	private UserInterface _userInterface;

	public ArtificialIntelligence(char piece) throws InvalidPieceException{
		super(piece);
	}

	/* ###################
	#  Public Interface  #
	################### */

	@Override
	public void play(State state) {
		
		_userInterface.display(state.toString());
		_userInterface.displayLine("Thinking...");

		decidePlay(state);

	}

	public void setUserInterface(UserInterface userInterface) {
		_userInterface = userInterface;
	}

	/* #####################
	#  Private Operations  #
	##################### */

	private void decidePlay(State state){

		ArrayList<Action> possibleActions = (ArrayList)state.possibleActions();

		int totalPossibleActions = possibleActions.size();

		Action chosen = possibleActions.get(new Random().nextInt(totalPossibleActions));

		try {
			state.play(this, chosen);
		} catch (TicTacToeException e) {
			_userInterface.displayLine("Did I Do Something Wrong??");
		}
	}

	/* ############
	#  Auxiliary  #
	############ */

	public void userInterfaceCallback(String input){
		//
	}

}
