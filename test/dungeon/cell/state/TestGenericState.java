package dungeon.cell.state;

import static org.junit.Assert.*;
import item.Item;
import item.MockItem;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

/**
 * Tests GenericState Class.
 * @author Jixiang Lu
 *
 */
public class TestGenericState
{
	/**
	 * Tests the initialization.
	 */
	@Test
	public void TestInitialization()
	{
		State state = new MockState();
		assertTrue(state instanceof State);
		assertTrue(state instanceof GenericState);
		assertNull(state.getItem(0));
		assertNull(state.getItem(1));
		assertNull(state.getLifeForm());
	}
	
	/**
	 * Tests the methods that are used to manipulate LifeForm and Items.
	 */
	@Test
	public void TestLifeFormAndItem()
	{
		State state = new MockState();
		LifeForm life = new MockLifeForm("Bob",50,60);
		Item item1 = new MockItem("Item1");
		Item item2 = new MockItem("Item2");
		//test getMethod.
		assertTrue(state.addLifeForm(life));
		assertEquals(life,state.getLifeForm());
		assertTrue(state.addItem(item1, 0));
		assertTrue(state.addItem(item2, 1));
		assertEquals(item1, state.getItem(0));
		assertEquals(item2,state.getItem(1));
		//index is out of range.
		assertNull(state.getItem(3));
		
		//test remove method.
		assertEquals(life,state.removeLifeForm());
		assertNull(state.getLifeForm());
		assertEquals(item1,state.removeItem(0));
		assertNull(state.getItem(0));
		assertNull(state.removeItem(3));
		
		//test clear method.
		state.clearCell();
		assertNull(state.getItem(1));
		
		//add item is in wrong position.
		assertFalse(state.addItem(item2, 3));
	}
	
}
