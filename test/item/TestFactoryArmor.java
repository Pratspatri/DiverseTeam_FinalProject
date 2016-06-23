package item;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test all methods in FactoryArmor
 * @author Malak
 *
 */
public class TestFactoryArmor 

{

	/**
     * Test Initialize
     * Create an object from NormalArmor
     * Create an object from SharpArmor which is special armor
     * Create an object from PowerArmor which is special armor
     * Create an object from NormalArmor when the type is invalid 
     */
	@Test
	public void TestInitialization()
	{   
		//create an object from Gun
		equals(FactoryArmor.buildArmor("normalarmor") instanceof NormalArmor); 
		//create an object from Spear
		equals(FactoryArmor.buildArmor("SharpArmor") instanceof SharpArmor);
		//create an object from Sword
		equals(FactoryArmor.buildArmor("PowerArmor") instanceof PowerArmor);
		//create an object from Gun when the type is invalid
		equals(FactoryArmor.buildArmor("Pistol") instanceof NormalArmor);
	}

}
