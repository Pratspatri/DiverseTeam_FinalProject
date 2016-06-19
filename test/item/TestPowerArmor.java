package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in PowerArmor class which is one of the SpecialArmor
 * @author Malak
 *
 */
public class TestPowerArmor 
{
    
	/**
     * Create an object form PowerArmor  class
     * Test ArmorPoints
     * Test description
     */
	@Test
	public void TestInitialization()
	{
		Armor power=new PowerArmor();
		equals(power instanceof PowerArmor );
		assertEquals("powerArmor",power.getDescription());
		assertEquals(30,power.getArmorPoints());
	}

	/**
     * Create how much damage if player use armor:
     * Test takehit > ArmorPoints
     * Test takehit < ArmorPoints
     */
	 @Test
	 public void TestUseArmor()
	 {
		Armor power=new PowerArmor();
        //take hit<=15(Armor points)
		power.useArmor(10);
		assertEquals(0,power.getDamageArmor());
		//take hit<=15(Armor points)
		power.useArmor(40);
		assertEquals(7,power.getDamageArmor());	
	 }
}
