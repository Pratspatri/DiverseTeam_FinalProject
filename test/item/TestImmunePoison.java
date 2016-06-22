package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in ImmunePoison class which is one of the Ability
 * @author Malak
 *
 */
public class TestImmunePoison 
{

	/**
     * Create an object form PowerArmor  class then wrap with ImmunePoison
     * Test description
     */
	@Test
	public void TestInitialization()
	{
		SpecialArmor power=new PowerArmor();
		AbilityArmor  poison=new ImmunePoison(power);
		assertTrue(power instanceof PowerArmor );
		assertTrue(poison instanceof ImmunePoison);
		assertEquals("immunepoison",poison.getDescription());
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
		AbilityArmor  poison=new ImmunePoison(power);
        //take hit<=15(Armor points)
		 poison.useArmor(10);
		assertEquals(0,power.getDamageArmor());
		assertEquals("Immune",poison.getHealthState());
		//take hit<=15(Armor points)
		 poison.useArmor(40);
		assertEquals(7,power.getDamageArmor());	
		assertEquals("Immune",poison.getHealthState());
	 }
}
