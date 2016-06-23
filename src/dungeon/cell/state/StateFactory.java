package dungeon.cell.state;


/**
 * It is used to create State which can be used to describe the cell.
 * 
 * @author Jixiang Lu
 *
 */
public class StateFactory
{
	public static final int WALL = 0;//NoWalkThroughState
	public static final int NO_WALL =1;//CanWalkThroughState
	public static final int KEY =2;//DoorState
	
	/**
	 * Create a Cell with its specific State
	 * @param state specific state.
	 * StateFactory.WALL---NoWalkThroughState
	 * StateFactory.NO_WALL---CanWalkThroughState
	 * StateFactory.KEY---DoorState
	 * @return the created State.
	 */
	public State getState(int state)
	{
		if(state == WALL)
		{
			
			return new NoWalkThroughState();
		}
		else if(state == NO_WALL)
		{
			return new CanWalkThroughState();
			
		}
		else if(state == KEY)
		{
			return new DoorState();
		}
		else
		{
			return null;
		}
	}
}