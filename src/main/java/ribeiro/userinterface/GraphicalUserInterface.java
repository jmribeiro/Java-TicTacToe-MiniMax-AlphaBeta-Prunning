package ribeiro.userinterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultCaret;

import ribeiro.Human;
import ribeiro.Player;

public class GraphicalUserInterface extends UserInterface implements ActionListener {

	private JFrame _window;
	private JTextArea _gameDisplay;
	private JTextField _inputArea;
	
	public GraphicalUserInterface(Player playerO, Player playerX) {
		super(playerO, playerX);
		initGraphics();
	}

	private void initGraphics() {
		_window = new JFrame("TIC TAC TOE");
		_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// JTextField
		_inputArea = new JTextField();
		_inputArea.addActionListener(this);
		_window.getContentPane().add(_inputArea, BorderLayout.SOUTH);

		// JTextArea
		_gameDisplay = new JTextArea();
		_gameDisplay.setEditable(false);
		DefaultCaret caret = (DefaultCaret)_gameDisplay.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		_window.getContentPane().add(new JScrollPane(_gameDisplay));
		
		_window.setSize(600, 600);
		_window.setVisible(true);
		
		
	}

	@Override
	public void display(String text) {
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						_gameDisplay.append(text);
					}
				}
			);
	}

	@Override
	public void displayLine(String text) {
		display(text+"\n");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//Code Ran When User Presses Enter
		_inputArea.setText("");
		getCurrentPlayer().userInterfaceCallback(event.getActionCommand());
	}

	@Override
	public void open() {
		_inputArea.setEditable(true);
	}

	@Override
	public void close() {
		_inputArea.setEditable(false);
	}

	@Override
	public void flush() {
		_gameDisplay.setText("");
	}

}
