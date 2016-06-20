package dungeon;

import dungeon.cell.Cell;
import dungeon.cell.CellFactory;
import dungeon.cell.state.State;
import lifeform.LifeForm;
import item.Item;

/**
 * Singleton pattern for Dungeon as there is only one.
 * @author Prathyusha Akshintala
 *
 */
public class Dungeon 
{

	private Cell cells[][];												// cells which hold everything
	private static Dungeon theDungeon;									// static variable

	/**
	 * Private constructor because we used Singleton Pattern
	 * @param row
	 * @param col
	 */
	private Dungeon(int row, int col)
	{
		cells = new Cell[row][col];
		CellFactory factory = new CellFactory();
		for (int i = 0; i < row; i++) 
		{
			for (int j = 0; j < col; j++) 
			{
				cells[i][j] = factory.getCell();//get the cell with canWalkThrough State.
			}
		}
	}
	/**
	 * Get lifeForm from the particular row and column
	 * @param row
	 * @param col
	 * @return lifeForm
	 */
	public LifeForm getLifeForm(int row, int col) 
	{
		if(row >= 0 && col >= 0)
		{
			if (row < cells.length && col < cells[row].length) 
			{
				return cells[row][col].getLifeForm();
			} else 
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	/**
	 * Add a lifeForm to the particular row and column
	 * @param row
	 * @param col
	 * @param entity
	 * @return
	 */
	public boolean addLifeForm(int row, int col, LifeForm entity)
	{
		if(row >= 0 && col >= 0)
		{
			if (row < cells.length && col < cells[row].length) 
			{
				entity.setLocation(row, col);
				return cells[row][col].addLifeForm(entity);
			} 
			else 
			{
				return false;
			}
		}
		return false;
	}
	/**
	 * Remove the lifeForm from the particular row and column
	 * @param row
	 * @param col
	 * @return lifeForm
	 */
	public LifeForm removeLifeForm(int row, int col) 
	{
		if(row >=0 && col >=0)
		{
			if (row < cells.length && col < cells[row].length)
			{
				LifeForm temp = cells[row][col].removeLifeForm();
				if (temp != null) 
				{
					temp.removeLocation();
				}
				return temp;
			} 
			else 
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	/**
	 * Get the dungeon instance (Singleton Pattern)
	 * @return dungeon
	 */
	public static Dungeon getDungeonInstance() 
	{
		if (theDungeon == null) 
		{
			theDungeon = new Dungeon(8, 8);
		}
		return theDungeon;
	}

	/**
	 * Reset the instance of the dungeon
	 */
	public static void resetInstance() 
	{
		theDungeon = null;
	}
	/**
	 * To add the item into the particular position, row and column
	 * @param row
	 * @param col
	 * @param item
	 * @param position
	 * @return
	 */
	public boolean addItem(int row, int col, Item item, int position) 
	{
		if (row < cells.length && col < cells[row].length) 
		{
			return cells[row][col].addItem(item, position);
		} 
		else 
		{
			return false;
		}
	}
	/**
	 * This removes the item from that row, column and position
	 * @param row
	 * @param col
	 * @param position
	 * @return Item
	 */
	public Item removeItem(int row, int col, int position) 
	{
		if (row < cells.length && col < cells[row].length) 
		{
			return (cells[row][col].removeItem(position));
		} 
		else 
		{
			return null;
		}
	}
	/**
	 * To get the distance between two lifeForms
	 * @param lifeform1
	 * @param lifeform2
	 * @return distance
	 */
	public int getDistance(LifeForm lifeform1, LifeForm lifeform2) 
	{
		if (lifeform1.getRow() != -1 && lifeform1.getCol() != -1 && lifeform2.getRow() != -1
				&& lifeform2.getCol() != -1)
		{
			double temp = Math.pow((lifeform2.getRow() - lifeform1.getRow()), 2);
			temp += Math.pow((lifeform2.getCol() - lifeform1.getCol()), 2);
			temp = Math.sqrt(temp);
			//temp *= 5;
			return (int) temp;
		}
		return -1;
	}
	/**
	 * To get the item present in that row and column of the dungeon
	 * @param row
	 * @param col
	 * @param position
	 * @return item
	 */
	public Item getItem(int row, int col, int position) 
	{
		try
		{
			return cells[row][col].getItem(position);
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			return null;
		}
	}
	/**
	 * To get the number of rows in the dungeon or field
	 * @return rows
	 */
	public int getNumberOfRow()
	{
		return cells.length;
	}
	/**
	 * To get the number of columns in the dungeon or field
	 * @return columns
	 */
	public int getNumberOfCol()
	{
		return cells[0].length;
	}
	/**
	 * To get the location of the given lifeForm
	 * @param entity
	 * @return location
	 */
	public int[] getLocation(LifeForm entity) 
	{
		int[] location = null;
		outerloop: for (int i = 0; i < 8; i++) 
		{
			for (int j = 0; j < 8; j++) {
				if (cells[i][j].getLifeForm() == entity) 
				{
					location = new int[2];
					location[0] = i;
					location[1] = j;
					break outerloop;
				}
			} 
		} 

		return location;
	}
	/**
	 * To set the state of the dungeon
	 * @param row
	 * @param col
	 * @param state
	 */
	public void setState(int row, int col, State state)
	{
		try
		{
			cells[row][col].setState(state);
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			
		}
	}
	/**
	 * To get the state of the dungeon
	 * @param row
	 * @param col
	 * @return state
	 */
	public State getState(int row, int col)
	{
		try
		{			
			return cells[row][col].getState();
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			return null;
		}
		
	}
	
	
	public boolean move (int row, int col)
	{
		LifeForm movedLife = cells[row][col].getLifeForm();
		if (movedLife != null) 
		{

			if (movedLife.getDirection().compareToIgnoreCase("North") == 0) 
			{

				int currentRow = row;
				int aboveRow = currentRow - 1;
				
					if (aboveRow >= 0 && cells[aboveRow][col].getLifeForm() == null) 
					{
						removeLifeForm(currentRow, col);
						addLifeForm(aboveRow, col, movedLife);
						currentRow = aboveRow;
					}
					aboveRow -= 1;
				
				return !(currentRow == row);
			} else if (movedLife.getDirection().compareToIgnoreCase("South") == 0) 
			{
				int currentRow = row;
				int underRow = currentRow + 1;
				
					if (underRow >= 0 && cells[underRow][col].getLifeForm() == null) 
					{
						removeLifeForm(currentRow, col);
						addLifeForm(underRow, col, movedLife);
						currentRow = underRow;
					}
					underRow += 1;
				
				return !(currentRow == row);
			} 
			else if (movedLife.getDirection().compareToIgnoreCase("East") == 0) 
			{
				int currentCol = col;
				int rightCol = currentCol + 1;
				
					if (rightCol >= 0 && cells[row][rightCol].getLifeForm() == null) 
					{
						removeLifeForm(row, currentCol);
						addLifeForm(row, rightCol, movedLife);
						currentCol = rightCol;
					}
					rightCol += 1;
				
				return !(currentCol == col);
			} 
			else if (movedLife.getDirection().compareToIgnoreCase("West") == 0) 
			{
				int currentCol = col;
				int leftCol = currentCol - 1;
				
					if (leftCol >= 0 && cells[row][leftCol].getLifeForm() == null) 
					{
						removeLifeForm(row, currentCol);
						addLifeForm(row, leftCol, movedLife);
						currentCol = leftCol;
					}
					leftCol -= 1;
				
				return !(currentCol == col);
			} 
			else 
			{
				return false;
			}
		} 
		else
			return false;
	}
}