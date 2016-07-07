package ribeiro.tictactoe.ai;


import ribeiro.tictactoe.Action;
import ribeiro.tictactoe.Player;
import ribeiro.tictactoe.State;
import ribeiro.tictactoe.ai.strategy.AlphaBetaPrunning;
import ribeiro.tictactoe.ai.strategy.DecisionStrategy;
import ribeiro.tictactoe.ai.strategy.Minimax;
import ribeiro.tictactoe.exception.*;
import ribeiro.tictactoe.userinterface.UserInterface;


public class ArtificialIntelligence extends Player{
	
	private UserInterface _userInterface;
	private DecisionStrategy _strategy;

	public ArtificialIntelligence(char piece) throws InvalidPieceException{
		super(piece);
		_strategy = new AlphaBetaPrunning();
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


	/* ############
	#  Auxiliary  #
	############ */

	public void userInterfaceCallback(String input){
		//
	}

}
