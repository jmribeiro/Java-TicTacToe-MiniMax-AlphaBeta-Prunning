package ribeiro.tictactoe.ai.strategy;

import ribeiro.tictactoe.Action;
import ribeiro.tictactoe.State;
import ribeiro.tictactoe.auxiliary.DebugMonitor;

public class Minimax implements DecisionStrategy{
	
	private int _consideredActions = 0;

	public Action decidePlay(State state) throws Exception{
		return Minimax_Decision(state);
	}

	private Action Minimax_Decision(State firstState) throws Exception{
		
		_consideredActions = 0;
		
	    Action bestAction = null;
	    int bestValue = (int) Double.NEGATIVE_INFINITY;
	    DebugMonitor.getInstance().displayLine("------------");
	    for(Action a : firstState.possibleActions()){
	        
	    	DEBUG_ACTIONS();
	        
	    	State result = firstState.result(a);
	        int currentValue = Min_Value(result, firstState.getCurrentPlayer());

	        
	        if(currentValue > bestValue){
	        	bestValue = currentValue;
	            bestAction = a;
	        }
	    }
	    
	    DebugMonitor.getInstance().displayLine("A total of "+_consideredActions+" possible actions...");
	    DebugMonitor.getInstance().displayLine("Best Move Is To Play "+bestAction.getPiece()+" On #"+bestAction.getPosition());;
	    
	    if(bestValue == 1){
	    	DebugMonitor.getInstance().displayLine("Game Is Won!");
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
    	DebugMonitor.getInstance().displayLine("Option #"+_consideredActions);

	}

}