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
		//assertNull(mario.getExpPoints()); check this with sameer TODO 
	}
	
	@Test
	public void testSetAndGetArmor()
	{
		Player mario = (Player) Player.getPlayerInstance();
		Armor sharp = new MockArmor("SharpArmor");
		mario.setArmor(sharp);
		assertEquals(sharp,mario.getArmor());
	}

	@Test
	public void testAddToInventory()
	{
		
	}
}
