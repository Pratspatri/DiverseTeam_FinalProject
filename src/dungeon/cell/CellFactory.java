package dungeon.cell;

import dungeon.cell.state.CanWalkThroughState;
import dungeon.cell.state.DoorState;
import dungeon.cell.state.NoWalkThroughState;

public class CellFactory
{
	public static final int WALL = 0;
	public static final int NO_WALL =1;
	public static final int KEY =2;
	public CellFactory()
	{
		
	}
	
	public Cell getCell()
	{
		return new Cell();
	}
	
	/**
	 * n-noWalkThroughState
	 * w-CanWalkThroughStae
	 * k -DoorState
	 * @param state
	 * @return
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
			return null;
		}
			
	}
}
