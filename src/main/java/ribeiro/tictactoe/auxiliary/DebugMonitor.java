package ribeiro.tictactoe.auxiliary;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultCaret;

public class DebugMonitor {
	
	private static DebugMonitor DEBUG_MONITOR;
	
	private JFrame _window;
	private JTextArea _display;
	
	public static DebugMonitor getInstance(){
		if(DEBUG_MONITOR == null){
			DEBUG_MONITOR = new DebugMonitor();
		}
		return DEBUG_MONITOR;
	}
	
	public void display(String message){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						_display.append(message);
					}
				}
			);
	}
	
	public void displayLine(String text) {
		display(text+"\n");
	}
	
	private DebugMonitor(){
		initGraphics();
	}
	
	private void initGraphics(){
		_window = new JFrame("Tic AI's Brain");
		
		_window.setDefaultCloseOperation(kill());
		
		// JTextArea
		_display = new JTextArea();
		_display.setEditable(false);
		DefaultCaret caret = (DefaultCaret)_display.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		_window.getContentPane().add(new JScrollPane(_display));
		
		_window.setSize(200, 400);
		_window.setVisible(true);
	}

	private static int kill(){
		DEBUG_MONITOR = null;
		return 0;
	}
}
