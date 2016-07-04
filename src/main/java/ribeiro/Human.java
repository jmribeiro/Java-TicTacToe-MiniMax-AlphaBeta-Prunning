package ribeiro;

import ribeiro.exception.*;
import ribeiro.state.HumanState;
import ribeiro.state.Playing;
import ribeiro.state.WaitingTurn;
import ribeiro.userinterface.*;
import ribeiro.userinterface.UserInterface;

public class Human extends Player{
	
	
	private UserInterface _userInterface;
	private HumanState _state;
	
	private State _currentGameState;
	
	private volatile boolean _hasPlayed;
	
	public Human(char piece) throws InvalidPieceException{
		
		super(piece);
		
		_userInterface = new GraphicalUserInterface(this);
		
	}

	/* ###################
	#  Public Interface  #
	################### */
	
	@Override
	public void play(State state) {
		
		_currentGameState = state;
		
		_userInterface.open();
		
		_userInterface.display(state.toString());
		_userInterface.display("Which Position Do You Wish To Play? - ");
		
		_hasPlayed = false;
		
		_state = new Playing(this);
		
		
		while(!_hasPlayed){
			
		}
		
		_userInterface.display(state.toString());
		_userInterface.display("Waiting Opponent's Turn");
		
		
	}
	
	public State getCurrentGame(){
		return _currentGameState;
	}
	

	/* #####################
	#  Private Operations  #
	##################### */



	/* ############
	#  Auxiliary  #
	############ */

	
	public void userInterfaceCallback(String input){
		//Code That UI Runs Goes Here
		try{
			_state.handleInput(input);
		}catch(NumberFormatException e){
			_userInterface.displayLine("Please Type A Number Between 1 and 9");
		}catch(TicTacToeException e){
			_userInterface.displayLine(e.getMessage());
		}
		
	}

	public void hasPlayed() {
		_hasPlayed = true;
		_userInterface.close();
		_state = new WaitingTurn(this);
	}

}
