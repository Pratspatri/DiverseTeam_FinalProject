package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in DamageDecorator which is abstract class
 * @author Malak
 *
 */
public class TestMockDamageDecorator 
{
	/**
     * Test Initialization to create an object from DamageDecorator 
     */
	@Test
	public void TestInitialization()  
	{
		MockDamageDecorator  mock=new MockDamageDecorator (new Spear());
		mock.setDescribtion("spear");
		assertEquals("spear",mock.getDescribtion());
	}

}
