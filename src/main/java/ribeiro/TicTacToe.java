package ribeiro;


import ribeiro.exception.*;
import ribeiro.userinterface.*;

public class TicTacToe{
	
	private static TicTacToe TIC_TAC_TOE;
	
	public static TicTacToe getInstance(){
		if(TIC_TAC_TOE == null){
			return new TicTacToe();
		}
		return TIC_TAC_TOE;
	}
	
	Player _playerO, _playerX;
	State game;
	
	UserInterfaceType _uiType;
	UserInterface _userInterface;
	
	public TicTacToe() {
		_uiType = UserInterfaceType.GUI;
		reset();
	}

	public void play() throws TicTacToeException{
		
		while(!game.gameOver()){

			/* Jogador O */
			_playerO.play(game);
			
			//Verifica Game Over
			if(game.gameOver()){
				terminate();
				break;
			}
			
			_userInterface.nextPlayer();
			
			//Jogador 2
			_playerX.play(game);

			//Verifica Game Over
			if(game.gameOver()){
				terminate();
				break;
			}
			
			_userInterface.nextPlayer();
			
		}
	}

	private void terminate() throws TicTacToeException{
		
		boolean draw = game.isDraw();
		
		_userInterface.display(game.toString());
		
		if(draw){
			_userInterface.display("It's A Draw!");
		}else{
			char winner = game.getWinner();
			_userInterface.display("Player "+winner+" Is Victorious!");
		}
		
		_userInterface.display("\nPlay Again? (Y/N)");
		
		if(_playerO instanceof Human){
			((Human)_playerO).terminate();
		}
		
		if(_playerX instanceof Human){
			((Human)_playerO).terminate();
		}

	}
	

	public void reset(){
		
		Board board = new Board();
		char firstPlayer = 'O';

		game = new State(board, firstPlayer);
		
		try{
			_playerO = new Human('O');
			_playerX = new Human('X');
			
			loadUserInterface(_uiType);
			
		}catch(InvalidPieceException e){
			//Make Sure It Doesnt Happen...
		}
	}
	
	private void loadUserInterface(UserInterfaceType type){
		switch(type){
			case GRAPHICAL:
			case GRAPHICALUSERINTERFACE:
			case GUI:
				_userInterface = new GraphicalUserInterface(_playerO, _playerX);
				break;
			case TEXT:
			case TEXTUSERINTERFACE:
			case TUI:
				_userInterface = new TextUserInterface(_playerO, _playerX);
				break;
		default:
			_userInterface = new GraphicalUserInterface(_playerO, _playerX);
			break;
			
		}
	}
}