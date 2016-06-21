package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in FactoryWeapon
 * @author Malak
 *
 */
public class TestFactoryWeapon 
{

	/**
     * Test Initialize
     * Create an object from Gun
     * Create an object from Spear
     * Create an object from Sword
     * Create an object from Gun when the type is invalid 
     */
	@Test
	public void TestInitialization()
	{   
		//create an object from Gun
		equals(FactoryWeapon.buildWeapon("gun") instanceof Gun);
		//create an object from Spear
		equals(FactoryWeapon.buildWeapon("spear") instanceof Spear);
		//create an object from Sword
		equals(FactoryWeapon.buildWeapon("Sword") instanceof Sword);
		//create an object from Gun when the type is invalid
		equals(FactoryWeapon.buildWeapon("Pistol") instanceof Gun);
	}

}
