package ribeiro.tictactoe.exception;

public class WrongPlayerTurnException extends TicTacToeException{
	public WrongPlayerTurnException(char playerPiece){
		super("It's Not "+playerPiece+"'s Turn!");
	}
}
