package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test the Pokemon methods 
 * @author Malak
 *
 */
public class TestAntiPoison 
{
    /**
     * Test Initialize
     */
	@Test
	public void TestInitialization()  
	{
		AntiPoison poison=new AntiPoison();
		assertTrue(poison.affect instanceof Healing );
		assertEquals("Healing",poison.affect.display());
	}
	
	 /**
     * Test taken method
     */
	@Test
	public void TestTakenMethod()  
	{
		AntiPoison poison=new AntiPoison();
		poison.taken(10);
		assertEquals(13,poison.getAmount());
	}

}
