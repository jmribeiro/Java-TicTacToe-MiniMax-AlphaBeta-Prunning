package ribeiro.tictactoe.exception;

public class PositionOccupiedException extends TicTacToeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3069367166313964336L;
	public PositionOccupiedException(int position){
		super(position+" Is Already Occupied!");
	}
	public PositionOccupiedException(int line, int collumn){
		super(line+","+collumn+" Is Already Occupied!");
	}
}

