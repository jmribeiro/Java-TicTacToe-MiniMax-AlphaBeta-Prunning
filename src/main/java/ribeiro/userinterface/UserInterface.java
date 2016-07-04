package ribeiro.userinterface;

import ribeiro.Human;

public abstract class UserInterface {
	
	protected Human _human;
	protected volatile boolean _open;
	
	public abstract void open();
	public abstract void close();
	
	public UserInterface(Human human){
		_human = human;
	}
	
	public abstract void display(String text);
	public abstract void displayLine(String text);
	
}
