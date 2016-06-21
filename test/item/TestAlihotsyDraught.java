package item;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test the AlihotsyDraught methods 
 * @author Malak
 *
 */
public class TestAlihotsyDraught 
{

	/**
     * Test Initialize
     */
	@Test
	public void TestInitialization()  
	{
		AlihotsyDraught alihotsy=new AlihotsyDraught();
		assertTrue(alihotsy.affect instanceof NoHealing );
		assertEquals("NoHealing",alihotsy.affect.display());
	}
	
	 /**
     * Test taken method
     */
	@Test
	public void TestTakenMethod()  
	{
		AlihotsyDraught alihotsy=new AlihotsyDraught();
		alihotsy.taken(10);
		assertEquals(7,alihotsy.getAmount());
	}

}
