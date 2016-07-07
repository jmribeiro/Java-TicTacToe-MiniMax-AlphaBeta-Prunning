package ribeiro.tictactoe.ai.strategy;

import ribeiro.tictactoe.Action;
import ribeiro.tictactoe.State;

public class AlphaBetaPrunning extends AdversarialStrategy {


	protected int getFirstMinValue(State firstState, Action action) throws Exception{
		return Min_Value(firstState.result(action), (int)Double.NEGATIVE_INFINITY, (int)Double.POSITIVE_INFINITY, firstState.getCurrentPlayer());
	}

	private int Max_Value(State state, int alpha, int beta, char maxPlayer) throws Exception{
	    
	    if(state.terminal()){
	        return state.utility(maxPlayer);
	    }

	    int maxValue = (int) Double.NEGATIVE_INFINITY;
	    
	    for(Action a : state.possibleActions()){
	    	
	    	int currentValue = Min_Value(state.result(a), alpha, beta, maxPlayer);
	    	
	    	maxValue = Math.max(currentValue, maxValue);

	    	if(currentValue >= beta){
	    		return currentValue;
	    	}

	    	alpha = Math.max(alpha, currentValue);
	    	
	    }

	    return maxValue;

	}

	private int Min_Value(State state, int alpha, int beta, char maxPlayer) throws Exception{
	    
	    if(state.terminal()){
	        return state.utility(maxPlayer);
	    }

	    int minValue = (int) Double.POSITIVE_INFINITY;
	    
	    for(Action a : state.possibleActions()){
	    	
	    	int currentValue = Max_Value(state.result(a), alpha, beta, maxPlayer);
	    	
	    	minValue = Math.min(currentValue, minValue);

	    	if(currentValue <= alpha){
	    		return currentValue;
	    	}

	    	beta = Math.min(beta, currentValue);
	    	
	    }

	    return minValue;

	}


}
