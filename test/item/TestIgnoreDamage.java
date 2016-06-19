package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in IgnoreDamage class which is one of the Ability
 * @author Malak
 *
 */
public class TestIgnoreDamage
{

	/**
     * Create an object form PowerArmor  class then wrap with ignoreDamage
     * Test description
     */
	@Test
	public void TestInitialization()
	{
		SpecialArmor power=new PowerArmor();
		AbilityArmor  ignore=new IgnoreDamage(power);
		equals(power instanceof PowerArmor );
		equals(ignore instanceof IgnoreDamage);
		assertEquals("ignore",ignore.getDescription());
	}

	/**
     * Create how much damage if player use armor:
     * Test takehit > ArmorPoints
     * Test takehit < ArmorPoints
     */
	 @Test
	 public void TestUseArmor()
	 {
		 SpecialArmor power=new PowerArmor();
		AbilityArmor  ignore=new IgnoreDamage(power);
        //take hit<=15(Armor points)
		 ignore.useArmor(10);
		assertEquals(0,power.getDamageArmor());
		assertEquals("Protected",ignore.getHealthState());
		//take hit<=15(Armor points)
		 ignore.useArmor(40);
		assertEquals(7,power.getDamageArmor());	
		assertEquals("Protected",ignore.getHealthState());
	 }
}
