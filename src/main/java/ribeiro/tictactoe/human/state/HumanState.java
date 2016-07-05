package ribeiro.tictactoe.human.state;

import ribeiro.tictactoe.human.Human;
import ribeiro.tictactoe.exception.TicTacToeException;

public abstract class HumanState {
	
	protected Human _human;
	
	public HumanState(Human human){
		_human = human;
	}
	
	public abstract void handleInput(String input) throws NumberFormatException, TicTacToeException;

}
