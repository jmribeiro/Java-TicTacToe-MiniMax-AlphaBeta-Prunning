package ribeiro.auxiliary;

import ribeiro.exception.*;
import ribeiro.*;

public class Utilities{

	public static boolean validPosition(int position){
		return position>=1 && position<=9;
	}

	public static boolean validCoordinates(int line, int collumn){
		return line>=0 && line<=2 && collumn>=0 && collumn<=2;
	}

	public static boolean validPiece(char piece){
		return piece=='X' || piece=='O';
	}

	public static int[] vectorToMatrix(int position) throws InvalidPositionException{
		
		int[] coordinates = new int[2];

		switch(position){
			case 1:
				coordinates[0] = 0;
				coordinates[1] = 0;
				break;
			case 2:
				coordinates[1] = 0;
				coordinates[1] = 1;
				break;
			case 3:
				coordinates[0] = 0;
				coordinates[1] = 2;
				break;
			case 4:
				coordinates[0] = 1;
				coordinates[1] = 0;
				break;
			case 5:
				coordinates[0] = 1;
				coordinates[1] = 1;
				break;
			case 6:
				coordinates[0] = 1;
				coordinates[1] = 2;
				break;
			case 7:
				coordinates[0] = 2;
				coordinates[1] = 0;
				break;
			case 8:
				coordinates[0] = 2;
				coordinates[1] = 1;
				break;
			case 9:
				coordinates[0] = 2;
				coordinates[1] = 2;
				break;
			default:
				throw new InvalidPositionException(position);
		}

		return coordinates;
	}

	public static int matrixToVector(int line, int collumn) throws InvalidCoordinatesException{
		
		if(line==0 && collumn==0){
			return 1;
		}else if(line==0 && collumn==1){
			return 2;
		}else if(line==0 && collumn==2){
			return 3;
		}else if(line==1 && collumn==0){
			return 4;
		}else if(line==1 && collumn==1){
			return 5;
		}else if(line==1 && collumn==2){
			return 6;
		}else if(line==2 && collumn==0){
			return 7;
		}else if(line==2 && collumn==1){
			return 8;
		}else if(line==2 && collumn==2){
			return 9;
		}else{
			throw new InvalidCoordinatesException(line, collumn);
		}
	}
}