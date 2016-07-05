package ribeiro.tictactoe.userinterface;

import ribeiro.tictactoe.Player;

public abstract class UserInterface {
	
	private Player _playerO, _playerX;
	private char _currentHuman;
	
	public UserInterface(Player playerO, Player playerX){
		
		setPlayers(playerO, playerX);
		
		_currentHuman = 'O';
	}
	
	protected void setPlayers(Player playerO, Player playerX){
		_playerO = playerO;
		_playerX = playerX;
		_playerO.setUserInterface(this);
		_playerX.setUserInterface(this);
	}
	
	public void nextPlayer(){
		if(_currentHuman == 'O'){
			_currentHuman = 'X';
		}else{
			_currentHuman = 'O';
		}
	}
	
	protected Player getCurrentPlayer() {
		if(_currentHuman == 'O'){
			return _playerO;
		}else{
			return _playerX;
		}
	}
	
	protected volatile boolean _open;
	
	public abstract void open();
	public abstract void close();
	
	public abstract void display(String text);
	public abstract void displayLine(String text);
	public abstract void flush();

	public void reset(Player playerO, Player playerX) {
		flush();
		setPlayers(playerO, playerX);
	}
	
}
