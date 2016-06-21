package dungeon.cell.state;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import item.Item;
import item.MockItem;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

/**
 * Tests NoWalkThroughState
 * @author Jixiang Lu
 *
 */
public class TestNoWalkThroughState
{

	/**
	 * Tests initialization
	 */
	@Test
	public void testInitialization()
	{
		State state = new NoWalkThroughState();
		assertTrue(state instanceof GenericState);
	}
	
	/**
	 * Tests the addLifeForm and addItem method which the NoWalkThroughState implement.
	 */
	@Test
	public void testAddMethod()
	{
		State state = new NoWalkThroughState();
		LifeForm life = new MockLifeForm("Bob",20,30);
		assertFalse(state.addLifeForm(life));
		assertNull(state.getLifeForm());
		
		Item item = new MockItem("Weapon");
		assertFalse(state.addItem(item, 0));
		assertNull(state.getItem(0));
		
		
		
	}

}
