package dungeon;

import lifeform.LifeForm;
import item.Item;

/**
 * Singleton pattern for Dungeon as there is only one.
 * @author Prathyusha Akshintala
 *
 */
public class Dungeon 
{

	private Cell cells[][];
	private static Dungeon theDungeon;

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
		if (row < cells.length && col < cells[row].length) 
		{
			return cells[row][col].getLifeForm();
		} else 
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
	/**
	 * Remove the lifeForm from the particular row and column
	 * @param row
	 * @param col
	 * @return lifeForm
	 */
	public LifeForm removeLifeForm(int row, int col) 
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
	// Each cell should have at most 5 items
	//TODO update this method accordingly after Malak's
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
	//TODO update this method accordingly after Malak's
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
			temp *= 5;
			return (int) temp;
		}
		return -1;
	}
	//TODO update this method accordingly after Malak's
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
	//TODO update this method accordingly after Jixiang's
	/**
	 * 
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
	//TODO update this method accordingly after Jixiang's
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
}