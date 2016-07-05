package ribeiro;

import ribeiro.tictactoe.TicTacToe;
import ribeiro.tictactoe.exception.*;


public class Main {
    public static void main( String[] args ) throws TicTacToeException{
        
    	if(args.length == 2){
    		TicTacToe.bootUp(args[0], args[1]);
    	}else{
    		TicTacToe.bootUp(null, null);
    	}
    	
        TicTacToe.getInstance().reset();
        TicTacToe.getInstance().play();

    }

//0: ai pvp -> default ai
//1: tui gui -> default tui

}
