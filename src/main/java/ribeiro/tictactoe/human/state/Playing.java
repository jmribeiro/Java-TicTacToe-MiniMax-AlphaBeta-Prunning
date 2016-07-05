package ribeiro.tictactoe.human.state;

import ribeiro.tictactoe.Action;
import ribeiro.tictactoe.human.Human;
import ribeiro.tictactoe.State;
import ribeiro.tictactoe.exception.TicTacToeException;

public class Playing extends HumanState {

	public Playing(Human human) {
		super(human);
	}

	@Override
	public void handleInput(String input) throws NumberFormatException, TicTacToeException{
		
		int play = Integer.parseInt(input);
		
		State currentGame = _human.getCurrentGame();
		
		Action action = new Action(_human.getPiece(), play); 

		currentGame.play( action);

		_human.hasPlayed();

	}
}
