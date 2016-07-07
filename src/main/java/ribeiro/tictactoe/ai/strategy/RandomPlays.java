package ribeiro.tictactoe.ai.strategy;

import java.util.ArrayList;
import java.util.Random;

import ribeiro.tictactoe.Action;
import ribeiro.tictactoe.State;

public class RandomPlays implements DecisionStrategy {

	public Action decidePlay(State state) throws Exception {
		ArrayList<Action> possibleActions = (ArrayList<Action>)state.possibleActions();

		int totalPossibleActions = possibleActions.size();

		return possibleActions.get(new Random().nextInt(totalPossibleActions));
	}

}
