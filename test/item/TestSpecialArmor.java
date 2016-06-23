package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in SpecialArmor which is abstract class
 * @author Malak
 *
 */
public class TestSpecialArmor 
{
	/**
     * Test Initialization to create an object from MockSpecialArmor
     */
	@Test
	public void TestInitialization() 
	{
		SpecialArmor specialarmor=new MockSpecialArmor("SharpArmor");
		assertTrue(specialarmor instanceof MockSpecialArmor);
		assertEquals("SharpArmor",specialarmor.getDescription());
		specialarmor.setArmorPoints(10);
		specialarmor.setDescription("PowerArmor");
		assertEquals(10,specialarmor.getArmorPoints());
		assertEquals("PowerArmor",specialarmor.getDescription());
	}

}
