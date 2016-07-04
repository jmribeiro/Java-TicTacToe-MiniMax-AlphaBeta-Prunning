package ribeiro.state;

import ribeiro.Human;
import ribeiro.TicTacToe;
import ribeiro.exception.TicTacToeException;

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
			TicTacToe.getInstance().reset();
			TicTacToe.getInstance().play();
			
		}else if(input.equals("N") || input.equals("n") 
			|| input.equals("No") || input.equals("no")
			|| input.equals("NO")
		){
			System.exit(0);
		}
	
	}

}
