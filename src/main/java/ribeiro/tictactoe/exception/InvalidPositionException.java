package ribeiro.tictactoe.exception;

public class InvalidPositionException extends TicTacToeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2974737979280363815L;

	public InvalidPositionException(int position){
		super(position+" Is Not A Valid Position!");
	}
}

