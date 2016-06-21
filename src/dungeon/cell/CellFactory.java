package dungeon.cell;

import item.Item;
import item.Keys;
import dungeon.cell.state.CanWalkThroughState;
import dungeon.cell.state.DoorState;
import dungeon.cell.state.NoWalkThroughState;

/**
 * This class is used to create a Cell instance.
 * 
 * @author Jixiang Lu
 *
 */
public class CellFactory
{
	public static final int WALL = 0;//NoWalkThroughState
	public static final int NO_WALL =1;//CanWalkThroughState
	public static final int KEY =2;//DoorState
	
	/**
	 * Constructor
	 */
	public CellFactory()
	{
	}
	
	/**
	 * Create a Cell with its Default State.
	 * @return the Cell Created.
	 */
	public Cell getCell()
	{
		return new Cell();
	}
	
	/**
	 * Create a Cell with its specific State.
	 * @param state it is used to specific State.
	 * CellFactory.WALL---NoWalkThroughState
	 * CellFactory.NO_WALL---CanWalkThroughState
	 * CellFactory.Key---DoorState with default key.
	 * @return the Cell Created
	 */
	public Cell getCellWithState(int state)
	{
		if(state == WALL)
		{
			
			return new Cell(new NoWalkThroughState());
		}
		else if(state == NO_WALL)
		{
			return new Cell(new CanWalkThroughState());
			
		}
		else if(state == KEY)
		{
			return new Cell(new DoorState());
		}
		else
		{
			return new Cell();
		}
			
	}
	
	/**
	 * Create a Cell with DoorState and specific Key.
	 * 
	 * @param key the key is used to open the DoorState.
	 * @return the Cell Created.
	 */
	public Cell getCellWithDoorState(Item key)
	{
		if(key instanceof Keys)
		{
			return new Cell(new DoorState(key));
		}
		else
		{
			return new Cell(new DoorState());
		}
	}
}
