package item;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test the Ultra methods 
 * @author Malak
 *
 */
public class TestUltra 
{

	/**
     * Test Initialize
     */
	@Test
	public void TestInitialization()  
	{
		Ultra ultra=new Ultra();
		equals(ultra.affect instanceof Healing );
	}
	
	 /**
     * Test taken method
     */
	@Test
	public void TestTakenMethod()  
	{
		Ultra ultra=new Ultra();
		ultra.taken(10);
		assertEquals(7,ultra.getAmount());
	}

}
