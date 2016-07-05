package ribeiro.tictactoe.ai;


import ribeiro.tictactoe.Action;
import ribeiro.tictactoe.Player;
import ribeiro.tictactoe.State;
import ribeiro.tictactoe.exception.*;
import ribeiro.tictactoe.userinterface.UserInterface;

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

		ArrayList<Action> possibleActions = (ArrayList<Action>)state.possibleActions();

		int totalPossibleActions = possibleActions.size();

		Action chosen = possibleActions.get(new Random().nextInt(totalPossibleActions));

		try {
			state.play(this, chosen);
		} catch (TicTacToeException e) {
			_userInterface.displayLine("Did I Do Something Wrong??");
		}
	}
	
	
	private State result(State state, Action action){
		return null;
	}
	
	/* ############
	#  Auxiliary  #
	############ */

	public void userInterfaceCallback(String input){
		//
	}

}
