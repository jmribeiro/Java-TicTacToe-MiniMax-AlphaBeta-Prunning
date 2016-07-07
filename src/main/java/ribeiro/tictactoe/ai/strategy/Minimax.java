package ribeiro.tictactoe.ai.strategy;

import ribeiro.tictactoe.Action;
import ribeiro.tictactoe.State;

public class Minimax extends AdversarialStrategy{
	
	protected int getFirstMinValue(State firstState, Action action) throws Exception{
		return Min_Value(firstState.result(action), firstState.getCurrentPlayer());
	}

	private int Max_Value(State state, char maxPlayer) throws Exception{
	    
	    if(state.terminal()){
	        return state.utility(maxPlayer);
	    }

	    int maxValue = (int) Double.NEGATIVE_INFINITY;
	    
	    for(Action a : state.possibleActions()){
	    	
	    	int currentValue = Min_Value(state.result(a), maxPlayer);
	    	
	    	maxValue = Math.max(currentValue, maxValue);
	    	
	    }

	    return maxValue;

	}

	private int Min_Value(State state, char maxPlayer) throws Exception{
	    
	    if(state.terminal()){
	        return state.utility(maxPlayer);
	    }

	    int minValue = (int) Double.POSITIVE_INFINITY;
	    
	    for(Action a : state.possibleActions()){

	    	int currentValue = Max_Value(state.result(a), maxPlayer);
			
	    	minValue = Math.min(currentValue, minValue);
	    }
	    
	    return minValue;

	}


}