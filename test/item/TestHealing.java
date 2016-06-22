package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in Healing class
 * @author Malak
 *
 */
public class TestHealing
{
    /**
     * Test Initialization
     * Create an object from Healing class
     * setAmount()
     * getAmount() 
     */
	@Test
	public void TestInitialization()
	{
		AffectBehavior  healing=new Healing ();
		assertTrue(healing instanceof Healing);
		healing.setAmount(5);
		assertEquals(5,healing.getAmount());	
	}
	
	/**
	 * Test taken() methods
	 */
	@Test
	public void TestTaken()
	{
	   AffectBehavior  healing=new Healing ();
	   healing.taken(6);
	   assertEquals(9,healing.getAmount());
	}

}
