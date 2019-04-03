package main;

import java.util.*;

public class TicTacToe{
public static int[][] ticbox;
	public static int win(int [][]tic) {
		//check all rows
		//loop through rows from 0 to 3 and check if all the 3 places have same marks
 		
		
		//check all cols
		//loop through columns from 0 to 3 and check if all the 3 places have same marks
 		
		//check both diagonals 
		
		int ele;
		int row, col = 0;
		boolean isEqual = true;
		for(row = 0; row < 3; row++)
		{
			ele = tic[row][col];
		    if(ele == 0)
		    	continue;
		    else
		    {
		    	isEqual = true;
		    	for(col = 1;col < 3; col++ )
		    	{
		    		if(ele != tic[row][col])
		    		{
		    			isEqual = false;
		    			break;
		    		}
		    	}
		    	if(isEqual)
		    		return ele;
		    }
		    		
		}
		row = 0;
		isEqual = true;
		for(col = 0; col < 3; col++ )
		{
			ele = tic[row][col];
			if(ele == 0)
				continue;
			else
			{
				isEqual = true;
				for(row = 1; row < 3; row++)
				{
					if(ele != tic[row][col])
					{
						isEqual = false;
						break;
					}
				}
				if(isEqual)
					return ele;
					
			}
		}
		row = 0; col = 0;
		isEqual = false;
		
		ele = tic[row][col];
		if(ele != 0)
		{
			isEqual = true;
			row++;
			col++;
			while(row < 3 )
			{
				if(ele != tic[row][col])
				{
					isEqual = false;
					break;
				}
				  row++;
				  col++;
			}
		}
		if(isEqual)
			return ele;
		row = 0; col = 2;
		ele = tic[row][col];
		if(ele != 0)
		{
			isEqual = true;
			col--;
			row++;
			while(row < 3 && col >= 0)
			{
				if(ele != tic[row][col])
				{
					isEqual = false;
					break;
				}
				row++;
				col--;
			}
		
		
		}
		if(isEqual)
			return ele;
		//}write your code here !!!
		
		
		
		return 0;
		
	}
	
	public static void printBox(int [][]tic) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(tic[i][j]);
			}
			System.out.println("");
		}
	}
	public static boolean validate(int a1,int a2,int [][] tic) {
		//check if a1 is between 0 & 3
		//check if a2 is between 0 & 3
		//check if the selected box is empty ie, already not marked by other player
		//if all checks passed return true.
		if((a1 >= 0 && a1 <= 2) && (a2 >= 0 && a2 <= 2) && tic[a1][a2] == 0)
			 return true;
		
		//Write your code here !!!
		
		
		return false;
	}
	public static void main(String args[]) {
		
		ticbox = new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				ticbox[i][j] = 0;
			}
		}
		
		 int chk = win(ticbox);

		boolean turn= true;
		int limit = 9;
		while(chk==0 && limit > 0) {
			//if true player 1	
			if(turn) {
				System.out.println("Player 1 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				if(valid) {
					ticbox[a1][a2] = 1;
					chk = win(ticbox);
					turn = false;
					limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
			}else {
				System.out.println("Player 2 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				if(valid) {
				ticbox[a1][a2] = 2;
				chk = win(ticbox);
				turn = true;
				limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
			}
			
			
			//if false player 2 
		}
		
		if(chk!=0) {
			System.out.println("The winner is Player "+chk);
		}else {
			System.out.println("Its a draw match!!");
		}
		
	}
}