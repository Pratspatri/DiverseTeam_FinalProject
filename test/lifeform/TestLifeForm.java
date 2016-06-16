package lifeform;

import static org.junit.Assert.*;
import item.MockWeapon;
import item.Weapon;
import gameplay.TimerObserver;

import org.junit.Test;

import dungeon.Dungeon;

public class TestLifeForm 
{

	@Test
	public void testInitialize()
	{
		LifeForm sansa = new MockLifeForm("Sansa", 15, 5); 
	    assertEquals("Sansa", sansa.getName()); 
	    assertEquals(15, sansa.getLifePoints()); 
	 
	    LifeForm robb = new MockLifeForm("Robb", -40, 0); 
	    assertEquals("Robb", robb.getName()); 
	    // LifeForm can not have negative life points so it should have 0. 
	    assertEquals(0, robb.getLifePoints()); 
	}
	
	@Test
	public void testSetAndGetStrength()
	{
		LifeForm sansa = new MockLifeForm("Sansa", 15, 5);
		sansa.setStrength(10);
		assertEquals(10,sansa.getStrength());
	}
	
	@Test 
	  public void testTrackTime() 
	  { 
	    LifeForm cedric = new MockLifeForm("Cedric", 40, 10); 
	    assertTrue(cedric instanceof TimerObserver); 
	}
	// check with Malak for equations of swords as it exceeds the life points
	/*@Test 
	  public void testAttack() 
	  { 
		Dungeon dungeon = Dungeon.getDungeonInstance();
	    LifeForm jamie = new MockLifeForm("Jamie", 30, 5); 
	    LifeForm cersei = new MockLifeForm("Cersei", 40, 10); 
	    Weapon sword = new MockWeapon("Sword");
	    dungeon.addLifeForm(1, 1, jamie);
	    dungeon.addLifeForm(1, 3, cersei);
	    dungeon.addItem(1, 1, sword, 1);
	    jamie.pickUpWeapon(sword);
	    
	    jamie.attack(cersei); 
	    assertEquals(35, cersei.getLifePoints()); 
	 
	    jamie.lifePoints = 0; 
	 
	    jamie.attack(cersei); 
	    // lifeForm2 remains 20 as lifeForm1 id dead. 
	    assertEquals(35, cersei.getLifePoints()); 
	} */
	
	@Test
	public void testSetAndGetHitPoints()
	{
		LifeForm jamie = new MockLifeForm("Jamie", 30, 5);
		jamie.setHitPoints(10);
		assertEquals(10,jamie.getHitPoints());
	}
	
	@Test
	public void testPickAndDropWeapon()
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		LifeForm jamie = new MockLifeForm("Jamie", 30, 5);
		Weapon sword = new MockWeapon("Sword");
		dungeon.addItem(1, 1, sword, 1);
		dungeon.addLifeForm(1, 1, jamie);
		jamie.pickUpWeapon(sword);
		assertEquals(sword, jamie.getWeapon());
		
		jamie.dropWeapon();
		assertNull(jamie.getWeapon());
	}
}
