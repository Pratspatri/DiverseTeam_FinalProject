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
		 assertEquals(15,gun.getBaseDamge(),.1);
		 assertEquals(40,((Gun) gun).getMaxAmmo(),.1);
		 assertEquals(40,((Gun) gun).getActualAmmo(),.1);
		 assertEquals(4,((Gun) gun).gettRateofFire(),.1);
		 assertEquals("gun",gun.getDescribtion());
		 ((Gun) gun).setActualAmmo(10);
		 assertEquals(10,((Gun) gun).getActualAmmo(),.1);
	}

	/**
	 * Test Calculate Damage
	 * In distance in the range and out of the range
	 */
	@Test
	public void TestCalculateDamage() 
	{
		Weapon gun = new Gun();
		// 0<=distance between the range<=30
		gun.calculateDamage(10);
		assertEquals(15,gun.getDamage());
		assertEquals(3,((Gun) gun).gettRateofFire(),.1);
		assertEquals(39,((Gun) gun).getActualAmmo(),.1);
		//distance out of the range
		gun.calculateDamage(50);
		assertEquals(15,gun.getDamage());
		assertEquals(2,((Gun) gun).gettRateofFire(),.1);
		assertEquals(38,((Gun) gun).getActualAmmo(),.1);
		 //reload when actual ammo is 0
		((Gun) gun).setActualAmmo(0);
	    ((Gun) gun).reload();
		assertEquals(40,((Gun) gun).getActualAmmo(),.1);
		
	}
}
