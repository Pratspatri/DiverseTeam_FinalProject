package dungeon.cell.state;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests StateFactory Class.
 * @author Jixiang Lu
 *
 */
public class TestStateFactory
{

	/**
	 * Tests State creation.
	 */
	@Test
	public void testCreateState()
	{
		StateFactory factory = new StateFactory();
		State state = factory.getState(StateFactory.KEY);
		assertTrue(state instanceof DoorState);
		state = factory.getState(StateFactory.NO_WALL);
		assertTrue(state instanceof CanWalkThroughState);
		state = factory.getState(StateFactory.WALL);
		assertTrue(state instanceof NoWalkThroughState);
		state = factory.getState(5);
		assertNull(state);
	}

}
