package ribeiro.tictactoe.human;

import ribeiro.tictactoe.Player;
import ribeiro.tictactoe.State;
import ribeiro.tictactoe.exception.*;
import ribeiro.tictactoe.human.state.GameOver;
import ribeiro.tictactoe.human.state.HumanState;
import ribeiro.tictactoe.human.state.Playing;
import ribeiro.tictactoe.human.state.WaitingTurn;


public class Human extends Player{
	
	private HumanState _state;
	
	private State _currentGameState;
	
	private volatile boolean _hasPlayed;
	private volatile boolean _playAgain;
	
	public Human(char piece) throws InvalidPieceException{
		super(piece);
	}
	
	/* ###################
	#  Public Interface  #
	################### */
	
	@Override
	public void play(State state) {
		
		_userInterface.open();
		
		_currentGameState = state;
		
		_state = new Playing(this);
		
		_userInterface.display(state.toString());
		_userInterface.displayLine("Which Position Do You Wish To Play?");
		
		_hasPlayed = false;
		
		while(!_hasPlayed){
			
		}
		
		_state = new WaitingTurn(this);
		
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
			_hasPlayed = false;
		}catch(TicTacToeException e){
			_userInterface.displayLine(e.getMessage());
			_hasPlayed = false;
		}catch(NullPointerException e){
			e.printStackTrace();
			_hasPlayed = false;
		}
		
	}

	public void hasPlayed() {
		_hasPlayed = true;
		_userInterface.close();
	}
	
	public void setReplayAnswer(boolean answer) {
		_userInterface.close();
		_playAgain = answer;
		_hasPlayed = true;
	}


	public boolean replayAnswer() {
		
		_userInterface.open();
		
		_userInterface.display("\nPlay Again? (Y/N)");
		_state = new GameOver(this);
		
		_hasPlayed = false;
		
		while(!_hasPlayed){
			
		}
		
		return _playAgain;
		
	}


}
