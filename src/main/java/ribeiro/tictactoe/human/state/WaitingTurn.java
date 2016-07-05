package ribeiro.tictactoe.human.state;

import ribeiro.tictactoe.human.Human;

public class WaitingTurn extends HumanState {

	public WaitingTurn(Human human) {
		super(human);
	}

	@Override
	public void handleInput(String input) {
		// Player Waiting Turn, what to do?
	}

}
