package lifeform;

import static org.junit.Assert.*;
import item.Armor;
import item.MockArmor;

import org.junit.After;
import org.junit.Test;

public class TestPlayer 
{
	@After
	public void after() 
	{
		Player.resetInstance();
	}
	
	public static void resetPlayer()
	{
		Player.resetInstance();
	}
	
	@Test
	public void testInitialization() 
	{
		LifeForm mario = Player.getPlayerInstance();

		LifeForm elyse = Player.getPlayerInstance();
		assertEquals(mario, elyse);
	}
	
	@Test
	public void testSetAndGetHealth()
	{
		Player mario = (Player) Player.getPlayerInstance();
		mario.setHealth("safe");
		assertEquals("safe",mario.getHealth());
	}
	
	@Test
	public void testSetAndGetExpPoints()
	{
		Player mario = (Player) Player.getPlayerInstance();
		mario.setExpPoints(100);
		assertEquals(100, mario.getExpPoints());
		mario.setExpPoints(-5);
		//assertNull(mario.getExpPoints()); check this TODO 
	}
	
	@Test
	public void testSetAndGetArmor()
	{
		Player mario = (Player) Player.getPlayerInstance();
		Armor sharp = new MockArmor("SharpArmor");
		mario.setArmor(sharp);
		assertEquals(sharp,mario.getArmor());
	}
	//TODO check with Jixiang if this is ok!
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
	
	@Test
	public void testRemoveFromInventory()
	{
		Player mario = (Player) Player.getPlayerInstance();
		Armor sharp = new MockArmor("SharpArmor");
		mario.addToInventory(sharp);
		mario.removeFromInventory(sharp);
		// TODO how to check if that is being returned?
		assertNull(mario.getItem());
	}
	//TODO after checking with Jixiang about how to assign array of items and positions
	@Test
	public void testUseItem()
	{
		
	}
	
	@Test
	public void testTakeHit()
	{
		Player mario = (Player) Player.getPlayerInstance();
		Creature creature = new MockCreature("dobby", 80, 5); 
		mario.takeHit(creature, 15);
		assertEquals(85,mario.getLifePoints());
		// Do other conditions
	}
}
