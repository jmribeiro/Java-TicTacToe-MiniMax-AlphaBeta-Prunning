package ribeiro.exception;

public class PositionOccupiedException extends TicTacToeException{
	public PositionOccupiedException(int position){
		super(position+" Is Already Occupied!");
	}
	public PositionOccupiedException(int line, int collumn){
		super(line+","+collumn+" Is Already Occupied!");
	}
}

