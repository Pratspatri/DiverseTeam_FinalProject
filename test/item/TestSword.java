package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in Sword class which is one of the weapon
 * @author Malak
 *
 */
public class TestSword 
{
    /**
     * Create an object form Sword class
     * Test BaseDamage
     * Test MaxRange
     * Test description
     */
	@Test
	public void TestInitialization()  
	{
		 Weapon sword =new Sword();
		 equals(sword instanceof Sword );
		 assertEquals(9,sword.getBaseDamge(),.1);
		 assertEquals(3,sword.getMaxrRange(),.1);
		 assertEquals("sword",sword.getDescribtion());
	}
	
	/**
	 * Test Calculate Damage
	 * In distance in the range and out of the range
	 */
	@Test
	public void TestCalculateDamage() 
	{
		Weapon sword =new Sword();
		// 0<=distance between the range<=3
		sword.calculateDamage(2);
		assertEquals(108,sword.getDamage());
		//distance out of the range
		sword.calculateDamage(10);
		assertEquals(108,sword.getDamage());
		
	}
}
