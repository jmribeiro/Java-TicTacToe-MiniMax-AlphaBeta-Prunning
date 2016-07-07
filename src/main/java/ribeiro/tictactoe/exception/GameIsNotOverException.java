package ribeiro.tictactoe.exception;

public class GameIsNotOverException extends TicTacToeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7211514953878049651L;

	public GameIsNotOverException(){
		super("The Game Is Not Over Yet!");
	}
}
