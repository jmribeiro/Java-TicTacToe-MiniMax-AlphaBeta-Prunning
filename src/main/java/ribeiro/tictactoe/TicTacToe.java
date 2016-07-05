package ribeiro.tictactoe;

import ribeiro.tictactoe.ai.ArtificialIntelligence;
import ribeiro.tictactoe.exception.*;
import ribeiro.tictactoe.human.Human;
import ribeiro.tictactoe.userinterface.*;

public class TicTacToe{
	
	private static TicTacToe TIC_TAC_TOE;
	
	public static TicTacToe getInstance(){
		if(TIC_TAC_TOE == null){
			TIC_TAC_TOE = new TicTacToe(true, true);
		}
		return TIC_TAC_TOE;
	}
	
	public static void bootUp(String ui, String ai) {
		if(ui==null || ai==null){
			TIC_TAC_TOE = new TicTacToe(true, true);
		}else if(ui.equals("tui") && ui.equals("ai")){
			TIC_TAC_TOE = new TicTacToe(false, true);
		}else if(ui.equals("gui") && ui.equals("ai")){
			TIC_TAC_TOE = new TicTacToe(true, true);
		}else if(ui.equals("tui") && ui.equals("pvp")){
			TIC_TAC_TOE = new TicTacToe(false, false);
		}else if(ui.equals("gui") && ui.equals("pvp")){
			TIC_TAC_TOE = new TicTacToe(true, false);
		}else{
			TIC_TAC_TOE = new TicTacToe(true, true);
		}
	}
	
	Player _playerO, _playerX;
	State game;
	boolean _ai;
	
	UserInterfaceType _uiType;
	UserInterface _userInterface;
	
	private TicTacToe() {
		
		_uiType = UserInterfaceType.GUI;
		
		reset();
	}
	
	private TicTacToe(boolean gui, boolean ai) {
		
		if(gui){
			_uiType = UserInterfaceType.GUI;
		}else{
			_uiType = UserInterfaceType.TUI;
		}
		
		_ai = ai;
		
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
		
		
		boolean playAgain = false;
		
		if(_playerO instanceof Human){
			playAgain = ((Human)_playerO).replayAnswer();
		}else if(_playerX instanceof Human){
			playAgain = ((Human)_playerO).replayAnswer();
		}
		
		
		if(playAgain){
			_userInterface.displayLine("Resetting Game, Please Wait...");
			reset();
			_userInterface.display("Done!");
			play();
		}else{
			System.exit(0);
		}
		
	}
	

	public void reset(){
		
		Board board = new Board();
		char firstPlayer = 'O';

		game = new State(board, firstPlayer);
		
		try{
			
			if(_ai){
				_playerO = new Human('O');
				_playerX = new ArtificialIntelligence('X');
			}else{
				_playerO = new Human('O');
				_playerX = new Human('X');
			}
			
			if(_userInterface == null){
				loadUserInterface(_uiType);
			}else{
				_userInterface.reset(_playerO, _playerX);
			}
			
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