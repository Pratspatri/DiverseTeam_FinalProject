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
		Weapon spear = new Spear();
		DamageDecorator  damage= new AlittleDamage(spear);
		assertTrue(damage instanceof AlittleDamage );
		damage.calculateDamage(2);
		assertEquals(26,damage.getDamage());
	}

	/**
     * Test default when weapon decorator by AlittleDamage twice
     */
	@Test
	public void TestAlittleDamageeAndAlittleDamage() 
	{
		Weapon spear = new Spear();
		AlittleDamage damage= new AlittleDamage(spear);
		AlittleDamage damage2= new AlittleDamage(spear);
		damage.calculateDamage(2);
		damage2.calculateDamage(2);
		assertEquals(26,damage.getDamage());
		assertEquals(28,damage2.getDamage());
	}
	/**
     * Test default when weapon decorator twice by one ReallyDamage and one AlittleDamage 
     */
	@Test
	public void TestReallyDamageAndAlittleDamage() 
	{
		Weapon sword = new Sword();
		ReallyDamage damage= new ReallyDamage(sword);
		AlittleDamage damage2= new AlittleDamage(sword);
		damage.calculateDamage(2);
		damage2.calculateDamage(2);
		assertEquals(26,damage.getDamage());
		assertEquals(28,damage2.getDamage());
	}
}
