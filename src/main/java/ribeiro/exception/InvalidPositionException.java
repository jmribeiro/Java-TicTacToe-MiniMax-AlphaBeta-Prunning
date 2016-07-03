package ribeiro.exception;

public class InvalidPositionException extends TicTacToeException{
	public InvalidPositionException(int position){
		super(position+" Is Not A Valid Position!");
	}
}

