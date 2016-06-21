package dungeon.cell;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dungeon.cell.state.CanWalkThroughState;
import dungeon.cell.state.DoorState;
import dungeon.cell.state.NoWalkThroughState;

/**
 * Tests CellFactory Class.
 * 
 * @author Jixiang Lu
 *
 */
public class TestCellFactory
{

	/**
	 * Tests getCell method and getCellWithState method.
	 */
	@Test
	public void test()
	{
		CellFactory fc = new CellFactory();
		Cell cl = fc.getCell();
		assertTrue(cl.getState() instanceof CanWalkThroughState);
		
		cl = fc.getCellWithState(CellFactory.KEY);
		assertTrue(cl.getState() instanceof DoorState);
		cl = fc.getCellWithState(CellFactory.NO_WALL);
		assertTrue(cl.getState() instanceof CanWalkThroughState);
		cl = fc.getCellWithState(CellFactory.WALL);
		assertTrue(cl.getState() instanceof NoWalkThroughState);
		
		cl = fc.getCellWithState(-4);
		assertTrue(cl.getState() instanceof CanWalkThroughState);
	}

}
