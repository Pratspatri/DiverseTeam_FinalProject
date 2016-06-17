package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test calculate damage after the weapon decorator by AlittleDamage 
 * @author Malak
 *
 */
public class TestAlittleDamage 
{

	  /**
     * Test default when weapon decorator by AlittleDamage
     */
	@Test
	public void TestInitialization() 
	{
		Weapon gun = new Gun();
		AlittleDamage damage= new AlittleDamage(gun);
		damage.calculateDamage(20);
		assertEquals(20,damage.getDamage());
	}

	/**
     * Test default when weapon decorator by AlittleDamage twice
     */
	@Test
	public void TestAlittleDamageeAndAlittleDamage() 
	{
		Gun gun = new Gun();
		AlittleDamage damage= new AlittleDamage(gun);
		AlittleDamage damage2= new AlittleDamage(gun);
		damage.calculateDamage(20);
		damage2.calculateDamage(20);
		assertEquals(20,damage.getDamage());
		assertEquals(40,damage2.getDamage());
	}
	/**
     * Test default when weapon decorator twice by one ReallyDamage and one AlittleDamage 
     */
	@Test
	public void TestReallyDamageAndAlittleDamage() 
	{
		Gun gun = new Gun();
		ReallyDamage damage= new ReallyDamage(gun);
		AlittleDamage damage2= new AlittleDamage(gun);
		damage.calculateDamage(20);
		damage2.calculateDamage(20);
		assertEquals(40,damage.getDamage());
		assertEquals(80,damage2.getDamage());
	}
}