package ribeiro.exception;

public class GameIsOverException extends TicTacToeException{
	public GameIsOverException(){
		super("The Game Is Already Over!");
	}
}
