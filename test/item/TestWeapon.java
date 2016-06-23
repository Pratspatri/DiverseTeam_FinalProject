package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all concert methods in Weapon class
 * @author Malak
 *
 */
public class TestWeapon
{
    /**
     * Test Initialization to create an object from MockWeapon
     */
	@Test
	public void TestInitialization() 
	{
		MockWeapon mock=new MockWeapon("Spear");
		assertEquals("Spear",mock.getDescribtion());
	}
	
	/**
     *  create an object from MockWeapon to test all methods in Weapon class
     *  Test setDescribtion() and gettDescribtion
     *  Test setBaseDamge() and getBaseDamge
     *  Test setMaxrRange() and getMaxrRange()
     *  Test setDamage() and getDamage()
     */
	@Test
	public void TestConcertMethods() 
	{
		Weapon mock=new MockWeapon("Spear");
		assertTrue(mock instanceof MockWeapon);
		mock.setDescribtion("Gun");
		mock.setBaseDamge(15);
        mock.setMaxrRange(40);
        mock.setDamage(5);
        assertEquals("Gun",mock.getDescribtion());
        assertEquals(15,mock.getBaseDamge(),.1);
        assertEquals(40,mock.getMaxrRange(),.1);
        assertEquals(5,mock.getDamage());	
	}
	

}
