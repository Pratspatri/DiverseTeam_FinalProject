package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in AbilityArmor which is abstract class
 * @author Malak
 *
 */
public class TestMockAbilityArmor 
{
	/**
     * Test Initialization to create an object from MockAbilityArmor 
     */
	@Test
	public void TestInitialization() 
	{
		MockAbilityArmor mock=new MockAbilityArmor(new PowerArmor());
		assertEquals("powerArmor",mock.getDescription());
		mock.setDescription("Power");
		assertEquals("Power",mock.getDescription());
		
	}

}
