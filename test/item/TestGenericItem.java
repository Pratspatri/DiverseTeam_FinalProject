package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all concert methods in Item class
 * @author Malak
 *
 */
public class TestGenericItem 
{
	/**
	 * Test Initialization
	 * set and  name of item 
	 */
	@Test
	public void TestInitialization() 
	{
		Item item=new MockItem("Armor");
		assertTrue(item instanceof MockItem);
		assertEquals("Armor",item.getItem());
		item.setItem("Weapon");
		assertEquals("Weapon",item.getItem());
		
	}

}
