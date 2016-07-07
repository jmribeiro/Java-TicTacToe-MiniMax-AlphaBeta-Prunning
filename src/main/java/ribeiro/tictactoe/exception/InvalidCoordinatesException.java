package ribeiro.tictactoe.exception;

public class InvalidCoordinatesException extends TicTacToeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4354755597347930446L;

	public InvalidCoordinatesException(int line, int collumn){
		super("Coordinates "+line+","+collumn+" Are Not Valid!");
	}
}