package ribeiro;

import ribeiro.auxiliary.*;
import ribeiro.exception.*;

public class TicTacToe{

	Player playerO, playerX;
	State game;

	public TicTacToe() {
		reset();
	}

	public void play() throws TicTacToeException{
		while(!game.gameOver()){
			//Le accao jogador 1
			
			Action playerOAction = playerO.getNextAction(game);
			game.play(playerO, playerOAction);

			//Verifica Game Over
			if(game.gameOver()){
				terminate();
				break;
			}

			//Jogador 2
			Action playerXAction = playerX.getNextAction(game);
			game.play(playerX, playerXAction);

			//Verifica Game Over
			if(game.gameOver()){
				terminate();
				break;
			}
		}
	}

	private void terminate() throws GameIsNotOverException{
		
		boolean draw = game.isDraw();

		if(draw){
			System.out.println("It's A Draw!");
		}else{
			char winner = game.getWinner();
			System.out.println("Player "+winner+" Is Victorious!");
		}

	}

	public void reset(){
		Board board = new Board();
		char firstPlayer = 'O';

		game = new State(board, firstPlayer);
		try{
			playerO = new Human('O');
			playerX = new Human('X');
		}catch(InvalidPieceException e){
			//Make Sure It Doesnt Happen...
		}
	}
}