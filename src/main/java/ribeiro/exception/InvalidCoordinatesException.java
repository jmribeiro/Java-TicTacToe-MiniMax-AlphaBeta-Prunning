package ribeiro.exception;

public class InvalidCoordinatesException extends TicTacToeException{
	public InvalidCoordinatesException(int line, int collumn){
		super("Coordinates "+line+","+collumn+" Are Not Valid!");
	}
}