package ribeiro.tictactoe.exception;

public class WrongPlayerTurnException extends TicTacToeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1318489669709473813L;

	public WrongPlayerTurnException(char playerPiece){
		super("It's Not "+playerPiece+"'s Turn!");
	}
}
