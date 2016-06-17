package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test calculate damage after the weapon decorator by ReallyDamage
 * @author Malak
 *
 */
public class TestReallyDamage 
{
    /**
     * Test default when weapon decorator by ReallyDamage
     */
	@Test
	public void TestInitialization() 
	{
		Weapon gun = new Gun();
		ReallyDamage damage= new ReallyDamage(gun);
		damage.calculateDamage(20);
		assertEquals(40,damage.getDamage());
	}
	
	/**
     * Test default when weapon decorator by ReallyDamage twice
     */
	@Test
	public void TestReallyDamageAndReallyDamage() 
	{
		Gun gun = new Gun();
		ReallyDamage damage= new ReallyDamage(gun);
		ReallyDamage damage2= new ReallyDamage(gun);
		damage.calculateDamage(20);
		damage2.calculateDamage(20);
		assertEquals(40,damage.getDamage());
		assertEquals(160,damage2.getDamage());
	}
	/**
     * Test default when weapon decorator twice by one AlittleDamage one  and  ReallyDamage 
     */
	@Test
	public void TestAlittleDamageAndReallyDamage() 
	{
		Gun gun = new Gun();
		AlittleDamage damage= new AlittleDamage(gun);
		ReallyDamage damage2= new ReallyDamage(gun);
		damage.calculateDamage(20);
		damage2.calculateDamage(20);
		assertEquals(20,damage.getDamage());
		assertEquals(80,damage2.getDamage());
	}
}
