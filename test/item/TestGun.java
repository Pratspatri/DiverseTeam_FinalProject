package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in Gun class which is one of the weapon
 * @author Malak
 *
 */
public class TestGun 
{
	/**
     * Create an object form Gun class
     * Test BaseDamage
     * Test MaxRange
     * Test description
     */
	@Test
	public void TestInitialization()
	{
		 Weapon gun = new Gun();
		 equals(gun instanceof Gun );
		 assertEquals(15,gun.getBaseDamge(),.1);
		 assertEquals(30,gun.getMaxrRange(),.1);
		 assertEquals("gun",gun.getDescribtion());
		 gun.setMaxrRange(10);
		 ((Gun) gun).setActualAmmo(10);
		 ((Gun) gun).setRateofFire(3);
	}

}
