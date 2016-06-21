package dungeon.cell;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import item.Item;
import item.Keys;
import item.MockItem;

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
		
		Item key = new Keys(1);
		cl = fc.getCellWithDoorState(key);
		assertTrue(cl.getState() instanceof DoorState);
		//can open the door
		assertTrue(cl.addItem(key, 0));
		//can not open the door.
		assertFalse(cl.addItem(new Keys(2), 0));
		
		//If the parameter is not key,
		//it will return a DoorCell can be opened by any key.
		cl = fc.getCellWithDoorState(new MockItem("Weapon"));
		assertTrue(cl.getState() instanceof DoorState);
		assertTrue(cl.addItem(key, 0));
	}

}
