package ribeiro;

import ribeiro.auxiliary.*;
import ribeiro.exception.*;

import java.io.*;

public class Main {
    public static void main( String[] args ) throws TicTacToeException{
        
        TicTacToe ttt = new TicTacToe();
        ttt.play();

        System.out.print("\nPlay Again? (Y/N) : ");

		boolean validRead = false;
		String input = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while(!validRead){
			
			try{
				input = reader.readLine();
			}catch(IOException e){
				System.out.print("Failed to read input, please try again...");
				continue;
			}

			if(input.equals("Y") || input.equals("y")
				|| input.equals("Yes") || input.equals("yes")
				|| input.equals("YES")
			){
				// Replay
				ttt.reset();
				ttt.play();
				validRead = true;
			}else if(input.equals("N") || input.equals("n") 
				|| input.equals("No") || input.equals("no")
				|| input.equals("NO")
			){
				//Exit
				System.out.println("Goodbye...");
				System.exit(0);
				validRead = true;
			}
			
		}

    }
}
