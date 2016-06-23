package lifeform;
/**
 * Test for Player class
 * @author - Prathyusha Akshintala
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import item.Armor;
import item.ImmunePoison;
import item.Item;
import item.MockArmor;
import item.MockItem;
import item.SharpArmor;
import item.Sword;

import org.junit.After;
import org.junit.Test;

import ability.Ability;
import ability.Poison;
import ability.Poke;
import dungeon.Dungeon;

public class TestPlayer 
{
	@After
	public void after() 
	{
		Player.resetInstance();
		Dungeon.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Resets the player
	 */
	public static void resetPlayer()
	{
		Player.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Initialization test
	 */
	@Test
	public void testInitialization() 
	{
		LifeForm mario = Player.getPlayerInstance();

		LifeForm elyse = Player.getPlayerInstance();
		assertEquals(mario, elyse);
		Player.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
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
	 * @author Prathyusha Akshintala
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
		Player.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Test for set and get armor to the player
	 */
	@Test
	public void testSetAndGetArmor()
	{
		Player mario = (Player) Player.getPlayerInstance();
		Armor sharp = new MockArmor("SharpArmor");
		mario.setArmor(sharp);
		assertEquals(sharp,mario.getArmor());
		Player.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
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
		Player.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Test to remove an item from the inventory
	 */
	@Test
	public void testRemoveFromInventory()
	{
		Player mario = (Player) Player.getPlayerInstance();
		Armor sharp = new MockArmor("SharpArmor");
		mario.addToInventory(sharp);
		mario.removeFromInventory(sharp);
		assertNull(mario.getItem());
		Player.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Test to use an item from the inventory
	 */
	@Test
	public void testUseItem()
	{
		Player mario = (Player) Player.getPlayerInstance();
		Sword sword = new Sword();
		mario.addToInventory(sword);
		boolean success = mario.useItem(0);
		assertTrue(success);
		Player.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Test for take hit method
	 */
	@Test
	public void testTakeHit()
	{
		Player.resetInstance();
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
		mario1.takeHit(bella, 20);
		assertEquals(78,mario.getLifePoints());
		// When armor is an instance of immune poison and creature is an instance of poke  
	    Player mario2 = (Player) Player.getPlayerInstance();  
	    Creature taylor = new Mummy("Taylor", 60, 25);  
	    Ability taylor1 = new Poke(taylor);  
	    Armor poiimm = new ImmunePoison(new SharpArmor());  
	    mario2.setArmor(poiimm);  
	    mario2.takeHit(taylor, taylor1.calculateDamage());  
	    assertEquals(71,mario.getLifePoints());
	    Player.resetInstance();
	}
	
	/**
	 * Test getItemFromInventory and etIndexOfItemFromInventory method
	 * @author Jixiang Lu
	 */
	@Test
	public void testInventory()
	{
		Player player = (Player) Player.getPlayerInstance();
		Item item = new MockItem("w");
		assertEquals(-1,player.getIndexOfItemFromInventory(item));
		player.addToInventory(item);
		assertEquals(item,player.getItemFromInventory(player.getIndexOfItemFromInventory(item)));
	}
}
