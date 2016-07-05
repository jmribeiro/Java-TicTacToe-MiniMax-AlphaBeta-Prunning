package ribeiro.tictactoe.ai.strategy;

import ribeiro.tictactoe.Action;
import ribeiro.tictactoe.State;

public class Minimax implements DecisionStrategy{
	
	private int _consideredActions = 0;

	public Action decidePlay(State state) throws Exception{
		return Minimax_Decision(state);
	}

	private Action Minimax_Decision(State firstState) throws Exception{
		
		_consideredActions = 0;
		
	    Action bestAction = null;
	    int bestValue = (int) Double.NEGATIVE_INFINITY;

	    for(Action a : firstState.possibleActions()){
	        
	    	DEBUG_ACTIONS();
	        
	        int currentValue = Min_Value(firstState.result(a), firstState.getCurrentPlayer());
	        
	        if(currentValue > bestValue){
	        	bestValue = currentValue;
	            bestAction = a;
	        }
	    }

	    return bestAction;
	}

	private int Max_Value(State state, char maxPlayer) throws Exception{
	    
	    if(state.terminal()){
	        return state.utility(maxPlayer);
	    }

	    int maxValue = (int) Double.NEGATIVE_INFINITY;
	    
	    
	    for(Action a : state.possibleActions()){
	    	
	    	int currentValue = Min_Value(state.result(a), maxPlayer);
	    	
	    	if(currentValue > maxValue){
	    		maxValue = currentValue;
	    	}
	    	
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
			
	    	if(currentValue < minValue){
	    		minValue = currentValue;
	    	}
	    }
	    
	    return minValue;

	}
	
	private void DEBUG_ACTIONS(){
    	_consideredActions++;
    	System.out.println("OPTION #"+_consideredActions);

	}

}