package inventory;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test InventoryFactory Class.
 * @author Jixiang Lu
 *
 */
public class TestInventoryFactory
{

	/**
	 * Test Inventory Creation.
	 */
	@Test
	public void testCreateInventory()
	{
		InventoryFactory factory = new InventoryFactory();
		Inventory inv = factory.getPlayerInventory();
		assertTrue(inv instanceof PlayerInventory);
		assertEquals(10, inv.getMaxSize());
		
		inv = factory.getPlayerInventory(5);
		assertTrue(inv instanceof PlayerInventory);
		assertEquals(5, inv.getMaxSize());
	}

}
