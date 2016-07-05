package ribeiro.tictactoe;

import ribeiro.tictactoe.auxiliary.*;
import ribeiro.tictactoe.exception.*;

public class Board {
	
	private char[][] _matrix;

	public Board(){
		initMatrix();
	}

	/* ###################
	#  Public Interface  #
	################### */

	public void play(Player player, Action action) throws WrongPlayerTurnException, GameIsOverException, InvalidPositionException, InvalidCoordinatesException, InvalidPieceException, PositionOccupiedException{
		if(player.getPiece()!=action.getPiece()){
			throw new WrongPlayerTurnException(player.getPiece());
		}else if(isFinal()){
			throw new GameIsOverException();
		}else{
			fillPosition(action.getPosition(), action.getPiece());
		}
	}

	@Override
	public String toString(){
		String boardString = "\n|----------------|\n";

		for(int i = 0; i<3; i++){
			boardString+="|";
			for(int j = 0; j<3; j++){
				boardString+= "  " + _matrix[i][j] + "  |";
			}
			boardString+= "\n|----------------|\n";
		}
		return boardString;
	}
	
	public char[] getBoardArray(){
		char[] vectorBoard = new char[9];
		int i = 0;
		for(int line = 0; line < 3; line++){
			for(int collumn = 0; collumn < 3; collumn++){
				vectorBoard[i++] = _matrix[line][collumn];
			}
		}
		return vectorBoard;
	}
	
	public boolean isFinal(){
		
		if(hasWinner()){
			return true;
		}

		for(int position = 1; position <= 9; position++){
			try{
				if(!isFilled(position)){
					return false;
				}
			}catch(InvalidPositionException | InvalidCoordinatesException e){
				//IGNORE
			}
		}
		return true;
	}

	public boolean isDraw(){
		return isFinal() && !hasWinner();
	}

	public boolean hasWinner(){
		try{
			if(
				(position(1) == position(5) && position(1) == position(9)) /* Diag 1 5 9 */
				||
				(position(1) == position(2) && position(1) == position(3)) /* Linha 1 2 3 */
				||
				(position(1) == position(4) && position(1) == position(7)) /* Coluna 1 4 7 */
				||
				(position(3) == position(6) && position(3) == position(9)) /* Coluna 3 6 9 */
				||
				(position(7) == position(8) && position(7) == position(9)) /* Linha 7 8 9 */
				||
				(position(7) == position(5) && position(7) == position(3)) /* Diag 7 5 3 */
				||
				(position(4) == position(5) && position(4) == position(6)) /* Linha 4 5 6 */
				||
				(position(2) == position(5) && position(2) == position(8)) /* Coluna 2 5 8*/
			)
			{
				return true;
			}


		}catch(InvalidPositionException | InvalidCoordinatesException e){
			//IGNORE
		}
		return false;
	}

	public char winner() throws GameIsNotOverException{
		if(!hasWinner()){
			throw new GameIsNotOverException();
		}

		try{
			if(
				position(1) == position(5) && position(1) == position(9)
				||
				position(1) == position(2) && position(1) == position(3)
				||
				position(1) == position(4) && position(1) == position(7)
			){
				return position(1);
			}else if(
				position(7) == position(8) && position(7) == position(9)
				||
				position(7) == position(5) && position(7) == position(3)
			){
				return position(7);
			}else if(
				position(3) == position(6) && position(3) == position(9)
				||
				position(4) == position(5) && position(4) == position(6)
			){
				return position(6);
			}else{
				return position(2);
			}
		}catch(InvalidPositionException | InvalidCoordinatesException e){
			throw new GameIsNotOverException();
		}
	}

	public boolean isFilled(int position) throws InvalidPositionException, InvalidCoordinatesException{
		if(!Utilities.validPosition(position)){
			throw new InvalidPositionException(position);
		}
		int[] coordinates = Utilities.vectorToMatrix(position);
		return _matrix[coordinates[0]][coordinates[1]] == 'X' || _matrix[coordinates[0]][coordinates[1]] == 'O';
	}

	public char position(int position) throws InvalidPositionException, InvalidCoordinatesException{
		if(!Utilities.validPosition(position)){
			throw new InvalidPositionException(position);
		}
		int[] coordinates = Utilities.vectorToMatrix(position);
		return _matrix[coordinates[0]][coordinates[1]];
	}

	public boolean isEmpty(int position) throws InvalidPositionException, InvalidCoordinatesException{
		if(!Utilities.validPosition(position)){
			throw new InvalidPositionException(position);
		}
		int[] coordinates = Utilities.vectorToMatrix(position);
		return _matrix[coordinates[0]][coordinates[1]] >= '1' && _matrix[coordinates[0]][coordinates[1]]<='9';
	}
	
	/* ############
	#  Auxiliary  #
	############ */
	
	private void initMatrix(){
		_matrix = new char[3][3];
		char position = '1';
		for(int line = 0; line < 3; line++){
			for(int collumn = 0; collumn < 3; collumn++){
				_matrix[line][collumn] = position++;
			}
		}
	}


	private void fillPosition(int position, char piece) throws InvalidPositionException, InvalidCoordinatesException, InvalidPieceException, PositionOccupiedException{
		
		if(!Utilities.validPosition(position)){
			throw new InvalidPositionException(position);
		}else if(!Utilities.validPiece(piece)){
			throw new InvalidPieceException(piece);
		}else{
			int[] coordinates = Utilities.vectorToMatrix(position);
			fillCoordinates(coordinates[0], coordinates[1], piece);
		}
	}
	
	private void fillCoordinates(int line, int collumn, char piece) throws InvalidPieceException, PositionOccupiedException, InvalidPositionException, InvalidCoordinatesException{
		if(!Utilities.validCoordinates(line, collumn)){
			throw new InvalidPositionException(Utilities.matrixToVector(line, collumn));
		}else if(!Utilities.validPiece(piece)){
			throw new InvalidPieceException(piece);
		}else if(!isEmpty(line, collumn)){
			throw new PositionOccupiedException(Utilities.matrixToVector(line, collumn));
		}else{
			_matrix[line][collumn] = piece;
		}
		
	}

	private boolean isEmpty(int line, int collumn) throws InvalidCoordinatesException{
		if(!Utilities.validCoordinates(line, collumn)){
			throw new InvalidCoordinatesException(line, collumn);
		}
		return _matrix[line][collumn] >= '1' && _matrix[line][collumn]<='9';
	}

}
