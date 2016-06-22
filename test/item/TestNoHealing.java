package item;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test all methods in NoHealing class
 * @author Malak
 *
 */
public class TestNoHealing 
{
	/**
     * Test Initialization
     * Create an object from NoHealing class
     * setAmount()
     * getAmount() 
     */
	@Test
	public void TestInitialization()
	{
		AffectBehavior  nohealing=new NoHealing ();
		assertTrue(nohealing instanceof NoHealing);
		nohealing.setAmount(5);
		assertEquals(5,nohealing.getAmount());	
	}
	
	/**
	 * Test taken() methods
	 */
	@Test
	public void TestTaken()
	{
	   AffectBehavior  nohealing=new NoHealing ();
	   nohealing.taken(6);
	   assertEquals(3,nohealing.getAmount());
	}


}
