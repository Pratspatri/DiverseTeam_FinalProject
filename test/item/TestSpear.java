package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in Spear class which is one of the weapon
 * @author Malak
 *
 */
public class TestSpear 
{  
	/**
     * Create an object form Spear class
     * Test BaseDamage
     * Test MaxRange
     * Test description
     */
	@Test
	public void TestInitialization() 
	{
		 Weapon spear= new Spear();
		 equals(spear instanceof Spear );
		 assertEquals(7,spear.getBaseDamge(),.1);
		 assertEquals(5,spear.getMaxrRange(),.1);
		 assertEquals("spear",spear.getDescribtion());	 
	}
   
	/**
	 * Test Calculate Damage
	 * In distance in the range and out of the range
	 */
	@Test
	public void TestCalculateDamage() 
	{
		Weapon spear= new Spear();
		// 0<=distance between the range<=5
		spear.calculateDamage(4);
		assertEquals(18,spear.getDamage());
		//distance out of the range
		spear.calculateDamage(10);
		assertEquals(18,spear.getDamage());
		
	}
}
