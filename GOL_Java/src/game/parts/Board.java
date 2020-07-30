package game.parts;

import java.util.Random;

public class Board {
    Cell[][] present;
    Cell[][] future;
	public Board()
	{
		present = new Cell[10][10];
		future = new Cell[10][10];
		setBoard();
		
	}
	
	public Board(int width, int height)
	{
		present = new Cell[height][width];
		future = new Cell[height][width];
		setBoard();
	}
	
	public void runGame(int generations)
	{
		int i =0;
		while(i < generations)
		{
			printBoard();
			advance();
			i++;
		}
		
	}
	
	
	
	private void setBoard()
	{
		Random randomno = new Random();
		int height = present.length;
		int width = present[0].length;
		
		for(int i =0; i < height; i++)
		{
			for(int j =0; j < width; j++)
			{
				present[i][j] = new Cell(randomno.nextBoolean());
				future[i][j] = new Cell();
			}
		}
		
	}

	
	
	private void advance()
	{
		int height = present.length;
		int width =  present[0].length;
		for(int i = 0; i < height; i++ )
		{
			for(int j = 0; j < present[i].length; j++)
			{
				//check neighbors
				int livingNeighbors = getLivingNeighbors(i, j, height, width);
				
				


				

				//run rules and apply to future array
				future[i][j].setIsAlive(setCellIsAlive(i, j, livingNeighbors));	
			}
		}
		
		//set present to future
		for(int i=0; i< height; i++)
		{
			present[i]=future[i];
		}
		
	}


	private boolean setCellIsAlive(int i, int j, int livingNeighbors)
{
	
	//Any live cell with fewer than two live neighbours dies, as if by underpopulation.
	if(present[i][j].getIsAlive() && livingNeighbors <2)
	{
		return false;
	}
	//Any live cell with two or three live neighbours lives on to the next generation.
	if(present[i][j].getIsAlive() && (livingNeighbors==2 || livingNeighbors==3))
	{
		return true;
	}
	//Any live cell with more than three live neighbours dies, as if by overpopulation.
	if(present[i][j].getIsAlive() && livingNeighbors > 3)
	{
		return false;
	}
	//Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	if(!present[i][j].getIsAlive() && livingNeighbors == 3)
	{
		return true;
	}
	
	return false;
}

	private int getLivingNeighbors(int i, int j, int height, int width)
{
	int livingNeighbors = 0;
	//check up
	if(i>0 )
	{	
		//check up
		if(present[i-1][j].getIsAlive())
		{
			livingNeighbors++;
		}
		//check up left
		if(j>0 && present[i-1][j-1].getIsAlive())
		{
			livingNeighbors++;
		}
		//check up right
		if(j<width-1 && present[i-1][j+1].getIsAlive())
		{
			livingNeighbors++;
		}
	}
	//check left
	if(j>0)
	{
		if(present[i][j-1].getIsAlive())
		{
			livingNeighbors++;
		}
		
	}
	//check right
	if(j<width-1)
	{
		if(present[i][j+1].getIsAlive())
		{
			livingNeighbors++;
		}
		
	}
	//check down
	if(i<height-1)
	{
		if(present[i+1][j].getIsAlive())
		{
			livingNeighbors++;
		}
		//check down left
		if(j>0 && present[i+1][j-1].getIsAlive())
		{			
			livingNeighbors++;			
			
		}
		//check down right
		if(j<width-1 && present[i+1][j+1].getIsAlive())
		{			
			livingNeighbors++;		
			
		}
	
	}
	return livingNeighbors;
	
}

	private void printBoard()
	{
		int height = present.length;
		int width = present[0].length;
 

	        
		for(int i =0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				int value = 0;
				if(present[i][j].getIsAlive())
				{
					value = 1;
				}
				System.out.print(value);
			}
			System.out.println();
		}
		System.out.println();
	}

	
}