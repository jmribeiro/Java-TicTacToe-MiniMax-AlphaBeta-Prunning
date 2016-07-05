package ribeiro.tictactoe.ai;


import ribeiro.tictactoe.Action;
import ribeiro.tictactoe.Player;
import ribeiro.tictactoe.State;
import ribeiro.tictactoe.ai.strategy.DecisionStrategy;
import ribeiro.tictactoe.ai.strategy.Minimax;
import ribeiro.tictactoe.exception.*;
import ribeiro.tictactoe.userinterface.UserInterface;

import java.util.*;

public class ArtificialIntelligence extends Player{
	
	private UserInterface _userInterface;
	private DecisionStrategy _strategy;

	public ArtificialIntelligence(char piece) throws InvalidPieceException{
		super(piece);
		_strategy = new Minimax();
	}

	public ArtificialIntelligence(char piece, DecisionStrategy strategy) throws InvalidPieceException{
		super(piece);
		_strategy = strategy;
	}

	/* ###################
	#  Public Interface  #
	################### */

	@Override
	public void play(State state) {
		
		_userInterface.displayLine("\nThinking...");

		try {
			
			Action bestAction = _strategy.decidePlay(state);
			state.play(bestAction);
			
		} catch (Exception e) {
			_userInterface.displayLine("That Was Too Much For Me!");
			_userInterface.displayLine(e.getMessage());
			e.printStackTrace();
		}

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
			state.play(chosen);
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
