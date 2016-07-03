package ribeiro;

import ribeiro.auxiliary.*;
import ribeiro.exception.*;

import java.io.*;

public class Human extends Player{
	
	BufferedReader _reader = new BufferedReader(new InputStreamReader(System.in));
	
	public Human(char piece) throws InvalidPieceException{
		super(piece);
	}

	/* ###################
	#  Public Interface  #
	################### */
	
	public Action getNextAction(State state){

		displayGame(state);

		boolean validAction = false;
		
		Action action = null; 
		
		while(!validAction){

			try{
				action = new Action(getPiece(), readPosition());
			}catch(InvalidPositionException | InvalidPieceException e){
				System.out.println(e.getMessage());
				continue;
			}
			
			if(!state.possibleActions().contains(action)){
				System.out.println("That Position Is Already Occupied!");
				continue;
			}
			validAction=true;
		}
		
		return action;
	}

	/* #####################
	#  Private Operations  #
	##################### */

	private void displayGame(State state){
		System.out.println(state.toString());
	}


	/* ############
	#  Auxiliary  #
	############ */

	private int readPosition(){

		System.out.print("Which position do you wish to play? : ");
		
		boolean validRead = false;
		String input = "";
		int position = 0;

		while(!validRead){
			try{
				input = _reader.readLine();
				position = Integer.parseInt(input);
			}catch(NumberFormatException e){
				System.out.print("Please type a valid number...");
				continue;
			}catch(IOException e){
				System.out.print("Failed to read input, please try again...");
				continue;
			}
			validRead = true;
		}
		return position;
	}
}
