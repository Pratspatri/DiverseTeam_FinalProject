package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in Armor which is abstract class
 * @author Malak
 *
 */
public class TestPotions 
{
	/**
     * Test Initialization to create an object from MockPotions
     */
	@Test
	public void TestInitialization() 
	{
		Potions mock=new MockPotions(5);
		assertTrue(mock instanceof MockPotions);
		assertEquals(5,mock.getAmount());
		mock.setAmount(10);
		assertEquals(10,mock.getAmount());
	}
	
	/**
     * Test AffectBehavior using by MockPotions
     */
	@Test
	public void TestAffectBehavior() 
	{
		MockPotions mock=new MockPotions(5);
		//assertNull(mock.affect);
		mock.taken(5);
		assertEquals(8,mock.getAmount());
	}

}
