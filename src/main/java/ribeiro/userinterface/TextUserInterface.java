package ribeiro.userinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ribeiro.Human;

public class TextUserInterface extends UserInterface implements Runnable {
	
	private BufferedReader _reader = new BufferedReader(new InputStreamReader(System.in));
	
	public TextUserInterface(Human human) {
		super(human);
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
				_human.userInterfaceCallback(_reader.readLine());
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



}