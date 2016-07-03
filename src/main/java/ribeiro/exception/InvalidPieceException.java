package ribeiro.exception;

public class InvalidPieceException extends TicTacToeException{
	public InvalidPieceException(char piece){
		super(piece+" Is Not A Valid Piece!");
	}
}

