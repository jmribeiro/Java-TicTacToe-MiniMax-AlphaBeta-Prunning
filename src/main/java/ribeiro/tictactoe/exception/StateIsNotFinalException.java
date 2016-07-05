package ribeiro.tictactoe.exception;

public class StateIsNotFinalException extends TicTacToeException{
	public StateIsNotFinalException(){
		super("Can't Compute Utility On A Non-Terminal State!");
	}
}