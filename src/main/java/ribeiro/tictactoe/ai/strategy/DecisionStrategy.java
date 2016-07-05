package ribeiro.tictactoe.ai.strategy;

import ribeiro.tictactoe.Action;
import ribeiro.tictactoe.State;

public interface DecisionStrategy{
	
	public Action decidePlay(State state) throws Exception;

}