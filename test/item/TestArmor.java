package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in Armor which is abstract class
 * @author Malak
 *
 */
public class TestArmor 
{
	
	/**
     * Test Initialization to create an object from MockArmor
     */
	@Test
	public void TestInitialization() 
	{
      MockArmor armor=new MockArmor("normalArmor");
      armor.setArmorPoints(15);
      assertEquals("normalArmor",armor.getDescription());
      assertEquals(15,armor.getArmorPoints());
      armor.setDescription("SharpArmor");
      assertEquals("SharpArmor",armor.getDescription());
	}

}
