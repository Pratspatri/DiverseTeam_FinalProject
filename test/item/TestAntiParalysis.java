package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test the AntiParalysis methods 
 * @author Malak
 *
 */
public class TestAntiParalysis 
{
	/**
     * Test Initialize
     */
	@Test
	public void TestInitialization()  
	{
		Potions anti=new AntiParalysis();
		assertTrue(anti instanceof AntiParalysis );
		assertTrue(anti.affect instanceof Healing );
		assertEquals("Healing",anti.affect.display());
	}

	 /**
     * Test taken method
     */
	@Test
	public void TestTakenMethod()  
	{
		AntiParalysis anti=new AntiParalysis();
		anti.taken(10);
		assertEquals(13,anti.getAmount());
	}
}
