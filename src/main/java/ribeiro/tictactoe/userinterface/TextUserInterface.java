package ribeiro.tictactoe.userinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ribeiro.tictactoe.Player;

public class TextUserInterface extends UserInterface implements Runnable {
	
	private BufferedReader _reader = new BufferedReader(new InputStreamReader(System.in));
	
	public TextUserInterface(Player playerO, Player playerX) {
		super(playerO, playerX);
	}
	
	public void open(){
		_open = true;
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		while(_open){
			try {
				getCurrentPlayer().userInterfaceCallback(_reader.readLine());
			} catch (IOException e) {
				displayLine(e.getMessage());
			}
		}
	}

	public void close(){
		_open = false;
	}
	

	@Override
	public void display(String text) {
		System.out.print(text);
		
	}
	
	
	@Override
	public void displayLine(String text) {
		System.out.println(text);
		
	}
	
	@Override
	public void flush(){
		final String os = System.getProperty("os.name");
		try {
			if (os.contains("Windows")){
				Runtime.getRuntime().exec("cls");
			}else{
				Runtime.getRuntime().exec("clear");
			}
		} catch (IOException e) {
			display("Failed To Flush...");
		}
	}


}