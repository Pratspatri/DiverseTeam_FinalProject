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
		MockItem item=new MockItem("Armor");
		assertEquals("Armor",item.getItem());
		item.setItem("Weapon");
		assertEquals("Weapon",item.getItem());
		
	}

}
