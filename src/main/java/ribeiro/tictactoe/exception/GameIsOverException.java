package ribeiro.tictactoe.exception;

public class GameIsOverException extends TicTacToeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -532957228204236239L;

	public GameIsOverException(){
		super("The Game Is Already Over!");
	}
}
