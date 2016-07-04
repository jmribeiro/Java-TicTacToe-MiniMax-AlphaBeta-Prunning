package ribeiro.state;

import ribeiro.Action;
import ribeiro.Human;
import ribeiro.State;
import ribeiro.exception.InvalidPieceException;
import ribeiro.exception.InvalidPositionException;
import ribeiro.exception.TicTacToeException;

public class Playing extends HumanState {

	public Playing(Human human) {
		super(human);
	}

	@Override
	public void handleInput(String input) throws NumberFormatException, TicTacToeException{
		//Player's Turn, what to do?
		
		int play = Integer.parseInt(input);
		
		State currentGame = _human.getCurrentGame();
		
		Action action = null; 
		

		action = new Action(_human.getPiece(), play);
		currentGame.play(_human, action);
		_human.hasPlayed();

		
	}
}
