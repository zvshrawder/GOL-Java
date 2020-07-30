package game.parts;

class Cell {
	boolean isAlive = false;
	public Cell()
	{
		
	}
	public Cell(boolean isAlive)
	{
		this.isAlive = isAlive; 
	}
	
	public void setIsAlive(boolean isAlive)
	{
		this.isAlive = isAlive;
	}
	public boolean getIsAlive()
	{
		return isAlive;
	}

}
