package ribeiro.tictactoe.exception;

public class InvalidPieceException extends TicTacToeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8995432682477149178L;

	public InvalidPieceException(char piece){
		super(piece+" Is Not A Valid Piece!");
	}
}

