package lifeform;
/**
 * Test for Player class 
 * @author - Prathyusha Akshintala
 */
import static org.junit.Assert.*;
import item.Armor;
import item.ImmunePoison;
import item.MockArmor;
import item.SharpArmor;

import org.junit.After;
import org.junit.Test;

import ability.Ability;
import ability.Poison;
import ability.Poke;

public class TestPlayer 
{
	@After
	public void after() 
	{
		Player.resetInstance();
	}
	/**
	 * Resets the player
	 */
	public static void resetPlayer()
	{
		Player.resetInstance();
	}
	/**
	 * Initialization test
	 */
	@Test
	public void testInitialization() 
	{
		LifeForm mario = Player.getPlayerInstance();

		LifeForm elyse = Player.getPlayerInstance();
		assertEquals(mario, elyse);
	}
	/**
	 * Test for set and get health status
	 */
	@Test
	public void testSetAndGetHealth()
	{
		Player mario = (Player) Player.getPlayerInstance();
		mario.setHealth("safe");
		assertEquals("safe",mario.getHealth());
	}
	/**
	 * Test for set and get exp points
	 */
	@Test
	public void testSetAndGetExpPoints()
	{
		Player mario = (Player) Player.getPlayerInstance();
		mario.setExpPoints(100);
		assertEquals(100, mario.getExpPoints());
		mario.setExpPoints(-5);
		assertEquals(0,mario.getExpPoints());  
	}
	/**
	 * Test for set and get armor to the player
	 */
	@Test
	public void testSetAndGetArmor()
	{
		Player mario = (Player) Player.getPlayerInstance();
		Armor sharp = new MockArmor("SharpArmor");
		mario.setArmor(sharp);
		assertEquals(sharp,mario.getArmor());
	}
	/**
	 * Test to add an item to the inventory
	 */
	@Test
	public void testAddToInventory()
	{
		Player mario = (Player) Player.getPlayerInstance();
		Armor sharp = new MockArmor("SharpArmor");
		boolean success = mario.addToInventory(sharp);
		assertTrue(success);
		
		boolean fail = mario.addToInventory(null);
		assertFalse(fail);
	}
	/**
	 * Test to remove an item from the inventory
	 */
	@Test
	public void testRemoveFromInventory()
	{
		Player mario = (Player) Player.getPlayerInstance();
		Armor sharp = new MockArmor("SharpArmor");
		mario.addToInventory(sharp);
		assertEquals(sharp,mario.removeFromInventory(sharp));
	}
	/**
	 * Test to use an item from the inventory
	 */
	@Test
	public void testUseItem()
	{
		
	}
	/**
	 * Test for take hit method
	 */
	@Test
	public void testTakeHit()
	{
		Player mario = (Player) Player.getPlayerInstance();
		Creature creature = new MockCreature("dobby", 80, 5); 
		mario.takeHit(creature, 15);
		assertEquals(85,mario.getLifePoints());
		// When the damage is invalid there is no change in the lifePoints
		mario.takeHit(creature, -15);
		assertEquals(85,mario.getLifePoints());
		// Using an armor and testing for takeHit method
		Armor sharp = new SharpArmor();
		mario.setArmor(sharp);
		Creature winky = new Goblin("Winky", 80, 5);
		mario.takeHit(winky, 30);
		assertEquals(78,mario.getLifePoints());
		// When armor is an instance of immune poison and creature is an instance of poison
		Player mario1 = (Player) Player.getPlayerInstance();
		Creature bella = new Goblin("Bella", 60, 5);
		bella = new Poison(bella);
		Armor immpoi = new ImmunePoison(new SharpArmor());
		mario1.setArmor(immpoi);
		mario1.takeHit(bella, bella.calculateDamage());
		assertEquals(78,mario.getLifePoints());
		// When armor is an instance of immune poison and creature is an instance of poke
		Player mario2 = (Player) Player.getPlayerInstance();
		Creature taylor = new Mummy("Taylor", 60, 25);
		Ability taylor1 = new Poke(taylor);
		Armor poiimm = new ImmunePoison(new SharpArmor());
		mario2.setArmor(poiimm);
		mario2.takeHit(taylor, taylor1.calculateDamage());
		assertEquals(71,mario.getLifePoints());
	}
}
