package ribeiro;

import ribeiro.exception.*;
import ribeiro.userinterface.*;

public class TicTacToe{

	Player _playerO, _playerX;
	State game;
	UserInterface _userInterface;
	
	public TicTacToe() {
		reset(UserInterfaceType.GUI);
	}

	public void play() throws TicTacToeException{
		while(!game.gameOver()){
			//Le accao jogador 1
			
			_playerO.play(game);

			//Verifica Game Over
			if(game.gameOver()){
				terminate();
				break;
			}

			//Jogador 2
			_playerX.play(game);

			//Verifica Game Over
			if(game.gameOver()){
				terminate();
				break;
			}
		}
	}

	private void terminate() throws GameIsNotOverException{
		
		boolean draw = game.isDraw();

		if(draw){
			System.out.println("It's A Draw!");
		}else{
			char winner = game.getWinner();
			System.out.println("Player "+winner+" Is Victorious!");
		}

	}

	public void reset(UserInterfaceType type){
		
		Board board = new Board();
		char firstPlayer = 'O';

		game = new State(board, firstPlayer);
		try{
			_playerO = new Human('O');
			_playerX = new Human('X');
			
			loadUserInterface(type);
			
		}catch(InvalidPieceException e){
			//Make Sure It Doesnt Happen...
		}
	}
	
	private void loadUserInterface(UserInterfaceType type){
		switch(type){
			case GRAPHICAL:
			case GRAPHICALUSERINTERFACE:
			case GUI:
				_userInterface = new GraphicalUserInterface((Human)_playerO, (Human)_playerX);
				break;
			case TEXT:
			case TEXTUSERINTERFACE:
			case TUI:
				_userInterface = new TextUserInterface((Human)_playerO, (Human)_playerX);
				break;
		default:
			_userInterface = new GraphicalUserInterface((Human)_playerO, (Human)_playerX);
			break;
			
		}
		
	}
}