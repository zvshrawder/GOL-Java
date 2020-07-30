import java.util.Scanner;

import game.parts.*;
public class main {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		int x = 0, y = 0, generations = 0;
		Scanner scan = new Scanner(System.in);
		boolean validEntry = false;
		System.out.println("What dimesions do you want for the game board (Y,X).");
		while(!validEntry)
		{
		try
		{
			System.out.println("Game Board values must be integers greater than 0.");
			
			y = scan.nextInt();
			x = scan.nextInt();
			if(y>0 && x>0)
				validEntry = true;
			}catch(Exception e)
			{
				System.out.println("Please only enter integers.");
				scan.nextLine();
			}
		}
		validEntry = false;
		while(!validEntry)
		{
			try
			{
			System.out.println("How many generations should be done?");
			generations = scan.nextInt(); 
			if(generations>0)
				validEntry = true;
			}catch(Exception e)
			{
				System.out.println("Please only enter integers.");
				scan.nextLine();
			}
		}
		scan.close();
		
		Board b = new Board(x,y);
		b.runGame(generations);
		

	}

}
