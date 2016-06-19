package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in NormalArmor class which is one of the Armor
 * @author Malak
 *
 */
public class TestNormalArmor 
{
	/**
     * Create an object form NormalArmor class
     * Test ArmorPoints
     * Test description
     */
	@Test
	public void TestInitialization()
	{
		Armor normal=new NormalArmor();
		equals(normal instanceof NormalArmor );
		assertEquals("normalArmor",normal.getDescription());
		assertEquals(15,normal.getArmorPoints());	
	}
	
	/**
     * Create how much damage if player use armor:
     * Test takehit > ArmorPoints
     * Test takehit < ArmorPoints
     */
	@Test
	public void TestUseArmor()
	{
		Armor normal=new NormalArmor();
        //take hit<=15(Armor points)
		normal.useArmor(10);
		assertEquals(0,normal.getDamageArmor());
		//take hit<=15(Armor points)
		normal.useArmor(30);
		assertEquals(15,normal.getDamageArmor());	
	}

}
