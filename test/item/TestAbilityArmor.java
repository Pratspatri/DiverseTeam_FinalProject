package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in AbilityArmor which is abstract class
 * @author Malak
 *
 */
public class TestAbilityArmor 
{
	/**
     * Test Initialization to create an object from MockAbilityArmor 
     */
	@Test
	public void TestInitialization() 
	{
		AbilityArmor mock=new MockAbilityArmor(new PowerArmor());
		assertTrue(mock.specialArmor instanceof PowerArmor);
		assertTrue(mock instanceof AbilityArmor);
		assertEquals("powerArmor",mock.getDescription());
		mock.setDescription("Power");
		assertEquals("Power",mock.getDescription());
		
	}

}
