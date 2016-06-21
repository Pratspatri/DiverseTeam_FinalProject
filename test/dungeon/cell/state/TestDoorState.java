package dungeon.cell.state;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import item.Item;
import item.Keys;
import item.MockItem;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

/**
 * Tests DoorState Class.
 * 
 * @author Jixiang Lu 
 *
 */
public class TestDoorState
{

	/**
	 * Tests Initialization.
	 */
	@Test
	public void testInitialization()
	{
		State state = new DoorState();
		assertTrue(state instanceof GenericState);
	}
	
	/**
	 * Tests addLifeForm method and addItem Method.
	 */
	@Test
	public void testAdd()
	{
		State state = new DoorState();
		LifeForm life = new MockLifeForm("Bob",20,30);
		//can't be added any LifeFrom.
		assertFalse(state.addLifeForm(life));
		assertNull(state.getLifeForm());
		
		//can't be opened by the item isn't key.
		Item item = new MockItem("Weapon");
		assertFalse(state.addItem(item, 0));
		
		//can be opened by any key.
		Item item2 = new Keys(2);
		assertTrue(state.addItem(item2, 0));
		
		//create a door with specific key.
		state = new DoorState(item2);
		//can't be opened by other key.
		Item item3 = new Keys(3);
		assertFalse(state.addItem(item3, 0));
		//can be opened by specific key
		assertTrue(state.addItem(item2, 0));
		
		//Create a door with other kind of item.
		//it will create a door can be opened by any key.
		state = new DoorState(item);
		assertTrue(state.addItem(item2, 0));
		assertTrue(state.addItem(item2, 0));
	}

}
