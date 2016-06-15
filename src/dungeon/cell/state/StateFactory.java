package dungeon.cell.state;


public class StateFactory
{
	public static final int WALL = 0;
	public static final int NO_WALL =1;
	public static final int KEY =2;
	
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
