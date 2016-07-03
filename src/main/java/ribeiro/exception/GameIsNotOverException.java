package ribeiro.exception;

public class GameIsNotOverException extends TicTacToeException{
	public GameIsNotOverException(){
		super("The Game Is Not Over Yet!");
	}
}
