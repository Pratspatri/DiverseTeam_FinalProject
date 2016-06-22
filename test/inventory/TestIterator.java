package inventory;

import static org.junit.Assert.*;
import item.Item;
import item.MockItem;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Tests Iterator Class.
 * @author Jixiang Lu
 *
 */
public class TestIterator
{

	/**
	 * Tests initialization
	 */
	@Test
	public void testInitialization()
	{
		ArrayList<Item> array = new ArrayList<Item>();
		Iterator it = new InventoryIterator(array);
		assertTrue(it instanceof Iterator);
		assertFalse(it.hasNext());
		assertNull(it.next());
	}
	
	/**
	 * Tests to iterate over 
	 */
	@Test
	public void testIterateOver()
	{
		ArrayList<Item> array = new ArrayList<Item>();
		Item item1 = new MockItem("W1");
		Item item2 = new MockItem("W2");
		Item item3 = new MockItem("W3");
		array.add(item1);
		array.add(item2);
		array.add(item3);
		
		Iterator it = new InventoryIterator(array);
		assertTrue(it.hasNext());
		assertEquals(item1,it.next());
		assertTrue(it.hasNext());
		assertEquals(item2,it.next());
		assertTrue(it.hasNext());
		assertEquals(item3,it.next());
		assertFalse(it.hasNext());
		assertNull(it.next());
		
		
	}
	
}
