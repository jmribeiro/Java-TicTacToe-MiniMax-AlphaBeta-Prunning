package ribeiro.tictactoe.ai.strategy;

import ribeiro.tictactoe.Action;
import ribeiro.tictactoe.State;
import ribeiro.tictactoe.auxiliary.DebugMonitor;

public abstract class AdversarialStrategy implements DecisionStrategy{
	
	private int _consideredActions = 0;
	private int _chosenAction = 0;

	public final Action decidePlay(State firstState) throws Exception{
		
		_consideredActions = 0;

		long start = System.nanoTime();

		Action bestAction = null;
		int bestValue = (int)Double.NEGATIVE_INFINITY;

		for (Action action : firstState.possibleActions()) {
			
			_consideredActions++;

			int currentValue = getFirstMinValue(firstState, action);

			if (currentValue > bestValue) {
				bestAction = action;
				bestValue = currentValue;
				_chosenAction = _consideredActions;
			}
			
		}

		long elapsedTime = System.nanoTime() - start;
		
		DEBUG_ACTIONS(elapsedTime, bestValue);
		
		return bestAction;
	}

	protected abstract int getFirstMinValue(State firstState, Action action) throws Exception;

	protected void DEBUG_ACTIONS(long elapsedTime, int bestValue){
		
		
		DebugMonitor.getInstance().displayLine("########");

    	for(int i = 1; i<=_consideredActions; i++){
    		if(i==_chosenAction){
				DebugMonitor.getInstance().displayLine("OPTION "+i+" - SELECTED "+((bestValue==1) ? "[WINNER OPTION]" : ""));
    		}else{
    			DebugMonitor.getInstance().displayLine("OPTION "+i);
    		}
    	}
    	DebugMonitor.getInstance().displayLine("--------\nTook me "+elapsedTime+" NanoSeconds!");
    	DebugMonitor.getInstance().displayLine("########");
	}

}