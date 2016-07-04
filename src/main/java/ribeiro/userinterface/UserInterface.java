package ribeiro.userinterface;

import ribeiro.Human;

public abstract class UserInterface {
	
	private Human _playerO, _playerX;
	private String _currentHuman;
	
	public UserInterface(Human playerO, Human playerX){
		
		_playerO = playerO;
		_playerX = playerX;
		
		_playerO.setUserInterface(this);
		_playerX.setUserInterface(this);
		
		_currentHuman = "playerO";
	}
	
	public void nextPlayer(){
		if(_currentHuman.equals("playerO")){
			_currentHuman = "playerX";
		}else{
			_currentHuman = "playerO";
		}
	}
	
	protected Human getCurrentHuman() {
		if(_currentHuman.equals("playerO")){
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
	
}
