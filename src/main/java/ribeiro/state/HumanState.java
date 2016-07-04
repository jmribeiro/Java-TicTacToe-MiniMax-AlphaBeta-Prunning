package ribeiro.state;

import ribeiro.Human;
import ribeiro.exception.TicTacToeException;

public abstract class HumanState {
	
	protected Human _human;
	
	public HumanState(Human human){
		_human = human;
	}
	
	public abstract void handleInput(String input) throws NumberFormatException, TicTacToeException;

}
