package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in DamageDecorator which is abstract class
 * @author Malak
 *
 */
public class TestDamageDecorator 
{
	/**
     * Test Initialization to create an object from DamageDecorator 
     */
	@Test
	public void TestInitialization()  
	{
		DamageDecorator  mock=new MockDamageDecorator (new Spear());
		assertTrue(mock instanceof MockDamageDecorator);
		mock.setDescribtion("spear");
		assertEquals("spear",mock.getDescribtion());
	}

}
