package ribeiro.tictactoe.ai.strategy;

import ribeiro.tictactoe.Action;
import ribeiro.tictactoe.State;
import ribeiro.tictactoe.auxiliary.DebugMonitor;

public abstract class AdversarialStrategy implements DecisionStrategy{
	
	private int _consideredActions = 0;

	public final Action decidePlay(State firstState) throws Exception{
		
		_consideredActions = 0;
		long start = System.nanoTime();

		Action bestAction = null;
		int bestValue = (int)Double.NEGATIVE_INFINITY;

		for (Action action : firstState.possibleActions()) {
			
			DEBUG_ACTIONS();
			
			int currentValue = getFirstMinValue(firstState, action);

			if (currentValue > bestValue) {
				bestAction = action;
				bestValue = currentValue;
			}
		}

		long elapsedTime = System.nanoTime() - start;
		DebugMonitor.getInstance().displayLine("It Took Me "+elapsedTime+" Nanoseconds To Decide!");
		DebugMonitor.getInstance().displayLine("Best Move Is To Play "+bestAction.getPiece()+" On Position #"+bestAction.getPosition()+"!");
		
		return bestAction;
	}

	protected abstract int getFirstMinValue(State firstState, Action action) throws Exception;

	protected void DEBUG_ACTIONS(){
    	_consideredActions++;
    	DebugMonitor.getInstance().displayLine("Option #"+_consideredActions);

	}

}