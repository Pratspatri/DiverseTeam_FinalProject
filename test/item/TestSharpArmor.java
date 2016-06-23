package item;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test all methods in SharpArmor class which is one of the SpecialArmor
 * @author Malak
 *
 */
public class TestSharpArmor 
{
	/**
     * Create an object form SharpArmor class
     * Test ArmorPoints
     * Test description
     */
	@Test
	public void TestInitialization()
	{
		Armor sharp=new SharpArmor();
		assertTrue(sharp instanceof SharpArmor );
		assertEquals("sharpArmor",sharp.getDescription());
		assertEquals(20,sharp.getArmorPoints());
	}
	
	/**
     * Create how much damage if player use armor:
     * Test takehit > ArmorPoints
     * Test takehit < ArmorPoints
     */
	@Test
	public void TestUseArmor()
	{
		Armor sharp=new SharpArmor();
        //take hit<=15(Armor points)
		sharp.useArmor(10);
		assertEquals(0,sharp.getDamageArmor());
		//take hit<=15(Armor points)
		sharp.useArmor(30);
		assertEquals(7,sharp.getDamageArmor());	
	}

}
