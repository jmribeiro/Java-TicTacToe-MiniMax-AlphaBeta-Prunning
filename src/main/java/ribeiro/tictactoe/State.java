package ribeiro.tictactoe;

import ribeiro.tictactoe.auxiliary.Utilities;
import ribeiro.tictactoe.exception.*;

import java.util.*;

public class State {
	
	private Board _board;
	private char _currentPlayer;

	public State(Board board, char playerPiece){
		_board = board;
		_currentPlayer = playerPiece;
	}

	public State(State copy){
		_board = new Board(copy._board);
		_currentPlayer = copy._currentPlayer;
	}

	/* ###################
	#  Public Interface  #
	################### */
	
	public List<Action> possibleActions(){
		
		List<Action> possibleActions = new ArrayList<Action>();

		for(int pos = 1; pos <= 9; pos++){
			try{

				if(_board.isEmpty(pos)){
					possibleActions.add(new Action(_currentPlayer, pos));
				}

			}catch(InvalidPositionException | InvalidCoordinatesException | InvalidPieceException e){
				//IGNORE
			}
		}

		return possibleActions;
	}

	public void play(Action action) throws GameIsOverException, InvalidPositionException, InvalidCoordinatesException, InvalidPieceException, PositionOccupiedException{

		_board.play(action);
		_currentPlayer = nextPlayer();

	}
	
	public String toString(){
		if(gameOver()){
			return _board.toString()+"\n";
		}else{
			return _board.toString()+"\n"+_currentPlayer+"'s Turn!\n";
		}
	}

	public char getWinner() throws GameIsNotOverException{
		return _board.winner();
	}

	public boolean hasWinner(){
		return _board.hasWinner();
	}

	public boolean isDraw(){
		return _board.isDraw();
	}

	public boolean gameOver() {
		return _board.isFinal() || _board.hasWinner();
	}
	
	public char getCurrentPlayer(){
		return _currentPlayer;
	}
	
	/* #####################
	#  Private Operations  #
	##################### */

	private char nextPlayer(){
		if(_currentPlayer=='O'){
			return 'X';
		}else{
			return 'O';
		}
	}

	/* ############
	#  Auxiliary  #
	############ */

	/* Minimax */

	//List<Action> possibleActions()

	public State result(Action a) throws TicTacToeException{
		State copy = new State(this);
		
		copy.play(a);

		return copy;
	}

	public boolean terminal(){
		return gameOver();
	}

	public int utility(char maxPlayer) throws TicTacToeException{

		if(!Utilities.validPiece(maxPlayer)){
			throw new InvalidPieceException(maxPlayer);
		}

		if(terminal()){
			if(isDraw()){
				return 0;
			}else {
				return (hasWinner() && getWinner()==maxPlayer) ? 1 : -1;	
			}
		}else{
			throw new StateIsNotFinalException();
		}
	}

}
