package item;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGenericItem {

	/**
	 * Test Initialization
	 * set and  name of item 
	 */
	@Test
	public void TestInitialization() 
	{
		MockItem item=new MockItem();
		item.setItem("Armor");
		assertEquals("Armor",item.getItem());
	}

}
