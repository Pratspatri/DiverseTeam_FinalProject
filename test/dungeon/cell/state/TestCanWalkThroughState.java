package dungeon.cell.state;

import static org.junit.Assert.*;
import item.Item;
import item.MockItem;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

/**
 * Tests CanWalkThroughState Class
 * @author Jixiang lu
 *
 */
public class TestCanWalkThroughState
{

	/**
	 * Tests the Initialization.
	 */
	@Test
	public void testInitialization()
	{
		State state = new CanWalkThroughState();
		assertTrue(state instanceof GenericState);
	}

	/**
	 * Tests addLifeForm method.
	 */
	@Test
	public void testAddLifeForm()
	{
		State state = new CanWalkThroughState();
		LifeForm life = new MockLifeForm("Bob",20,30);
		LifeForm life2 = new MockLifeForm("Last",20,30);
		
		//there is no LifeForm.
		assertTrue(state.addLifeForm(life));
		assertEquals(life, state.getLifeForm());
		
		//there exist an LifeForm.
		assertFalse(state.addLifeForm(life2));
		assertEquals(life, state.getLifeForm());
		
	}

	/**
	 * Tests addItem method.
	 */
	@Test
	public void testAddItem()
	{
		State state = new CanWalkThroughState();
		Item item = new MockItem("Weapon");
		Item item2 = new MockItem("Weapon2");
		Item item3 = new MockItem("Weapon3");
		
		assertTrue(state.addItem(item, 0));
		assertEquals(state.getItem(0),item);
		
		//add another item in same position
		assertFalse(state.addItem(item3, 0));
		assertEquals(state.getItem(0),item);
		
		//add item in invalid postion.
		assertFalse(state.addItem(item3, 3));
		assertNull(state.getItem(3));
		
		//add item in another position 
		assertTrue(state.addItem(item2, 1));
		assertEquals(state.getItem(1),item2);
	}

}
