package ribeiro.state;

import ribeiro.Human;

public class WaitingTurn extends HumanState {

	public WaitingTurn(Human human) {
		super(human);
	}

	@Override
	public void handleInput(String input) {
		// Player Waiting Turn, what to do?
	}

}
