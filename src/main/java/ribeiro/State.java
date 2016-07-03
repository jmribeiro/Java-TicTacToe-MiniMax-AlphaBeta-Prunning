package ribeiro;

import ribeiro.auxiliary.*;
import ribeiro.exception.*;

import java.util.*;

public class State {
	
	private Board _board;
	private char _currentPlayer;

	public State(Board board, char playerPiece){
		_board = board;
		_currentPlayer = playerPiece;
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

	public void play(Player player, Action action) throws WrongPlayerTurnException, GameIsOverException, InvalidPositionException, InvalidCoordinatesException, InvalidPieceException, PositionOccupiedException{
		if(player.getPiece()!=_currentPlayer){
			throw new WrongPlayerTurnException(player.getPiece());
		}
		_currentPlayer = nextPlayer();
		_board.play(player, action);
	}
	public String toString(){
		return _board.toString()+"\n"+_currentPlayer+"'s Turn!\n";
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

}
