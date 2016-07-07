package ribeiro.tictactoe.human.state;

import ribeiro.tictactoe.human.Human;
import ribeiro.tictactoe.exception.TicTacToeException;

public class GameOver extends HumanState {

	public GameOver(Human human) {
		super(human);
	}

	@Override
	public void handleInput(String input) throws NumberFormatException, TicTacToeException {

		if(input.equals("Y") || input.equals("y")
			|| input.equals("Yes") || input.equals("yes")
			|| input.equals("YES")
		){
			
			_human.setReplayAnswer(true);
			
		}else if(input.equals("N") || input.equals("n") 
			|| input.equals("No") || input.equals("no")
			|| input.equals("NO")
		){
			_human.setReplayAnswer(false);
		}
	
	}

}
