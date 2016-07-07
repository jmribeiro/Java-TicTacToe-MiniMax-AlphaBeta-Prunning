package ribeiro.tictactoe.exception;

public class StateIsNotFinalException extends TicTacToeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7253429826067275444L;

	public StateIsNotFinalException(){
		super("Can't Compute Utility On A Non-Terminal State!");
	}
}