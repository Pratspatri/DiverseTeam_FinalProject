package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test the Mega methods 
 * @author Malak
 *
 */
public class TestMega 
{
	/**
     * Test Initialize
     */
	@Test
	public void TestInitialization()  
	{
		Mega mega=new Mega();
		equals(mega.affect instanceof Healing );
	}

	 /**
     * Test taken method
     */
	@Test
	public void TestTakenMethod()  
	{
		Mega mega=new Mega();
		mega.taken(10);
		assertEquals(13,mega.getAmount());
	}
}
