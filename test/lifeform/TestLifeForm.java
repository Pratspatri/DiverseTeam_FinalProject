package lifeform;
/**
 * Test class for LifeForm
 */
import static org.junit.Assert.*;
import item.Armor;
import item.MockWeapon;
import item.PowerArmor;
import item.SharpArmor;
import item.Sword;
import item.Weapon;
import gameplay.TimerObserver;

import org.junit.Test;

import dungeon.Dungeon;

public class TestLifeForm 
{

	/**
	 * Initialization test
	 */
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
	    //Strength cannot be negative
	    LifeForm arya = new MockLifeForm("Arya", 40, -10);
	    assertEquals(0, arya.getStrength());
	    arya.setLifePoints(50);
	    assertEquals(50, arya.getLifePoints());
	    // Cannot set life points to negative
	    arya.setLifePoints(-5);
	    assertEquals(50, arya.getLifePoints());
	}
	/**
	 * Test to get and set strength
	 */
	@Test
	public void testSetAndGetStrength()
	{
		LifeForm sansa = new MockLifeForm("Sansa", 15, 5);
		sansa.setStrength(10);
		assertEquals(10,sansa.getStrength());
		// Cannot have negative strength
		sansa.setStrength(-10);
		assertEquals(0,sansa.getStrength());
	}
	/**
	 * Test to track time
	 */
	@Test 
	  public void testTrackTime() 
	  { 
	    LifeForm cedric = new MockLifeForm("Cedric", 40, 10); 
	    assertTrue(cedric instanceof TimerObserver); 
	}
	/**
	 *	Test for attach method and its various cases 
	 */
	@Test 
	  public void testAttack() 
	  { 
		Dungeon dungeon = Dungeon.getDungeonInstance();
	    LifeForm jamie = new Goblin("Jamie", 30, 5); 
	    LifeForm cersei = new Mummy("Cersei", 40, 10); 
	    Weapon sword = new Sword();
	    dungeon.addLifeForm(1, 1, jamie);
	    dungeon.addLifeForm(1, 3, cersei);
	    dungeon.addItem(1, 1, sword, 1);
	    jamie.pickUpWeapon(sword);
	    // Only when there is weapon
	    jamie.attack(cersei); 
	    assertEquals(18, cersei.getLifePoints()); 
	 
	    jamie.lifePoints = 0; 
	 
	    jamie.attack(cersei); 
	    // lifeForm2 remains 19 as lifeForm1 is dead. 
	    assertEquals(18, cersei.getLifePoints()); 
	    
	    // When there is weapon and armor involved
	    Dungeon dungeon1 = Dungeon.getDungeonInstance();
	    Player mario = (Player) Player.getPlayerInstance(); 
	    LifeForm bran = new Mummy("Bran", 40, 10); 
	    Weapon sword1 = new Sword();
	    dungeon1.addLifeForm(2, 1, mario);
	    dungeon1.addLifeForm(2, 3, bran);
	    dungeon1.addItem(1, 1, sword1, 1);
	    bran.pickUpWeapon(sword1);
	    assertEquals(3,bran.getAttackDistance());
	    assertEquals(0,mario.getAttackDistance());
	    Armor sharp = new SharpArmor();
	    mario.setArmor(sharp);
	    bran.attack(mario);
	    /**
	     * No change in the life points because player has sharp armor and that reduces
	     * damage by 3 points. And then it gets checked if the armor points pertaining
	     * to that armor is > or < the damage and reduces accordingly.
	     * If armor points are < damage, then those points are subtracted from damage and
	     * the remaining damage is returned to takeHit method. If it is > then, no damage
	     * is done. 
	     */
	    assertEquals(100,mario.getLifePoints());
	    /**
	     * Another case - we remove the creature from one cell and place in another.
	     * Then we add another armor and test accordingly
	     */
	    dungeon1.removeLifeForm(2, 3);
	    dungeon1.addLifeForm(2, 4, bran);
	    Armor power  = new PowerArmor();
	    mario.setArmor(power);
	    bran.attack(mario);
	    assertEquals(100,mario.getLifePoints());
	    /**
	     * Another case when weapon is null
	     */
	    Player.resetInstance();
	    Player dave = (Player) Player.getPlayerInstance();
	    dungeon1.addLifeForm(2, 9, dave);
	    LifeForm jon = new Mummy("Jon", 40, 10);
	    dungeon1.addLifeForm(2, 5, jon);
	    jon.attack(dave);
	    assertEquals(90,dave.getLifePoints());
	} 
	/**
	 * Test to get and set hit points
	 */
	@Test
	public void testSetAndGetHitPoints()
	{
		LifeForm jamie = new MockLifeForm("Jamie", 30, 5);
		jamie.setHitPoints(10);
		assertEquals(10,jamie.getHitPoints());
		jamie.setHitPoints(-10);
		assertEquals(10,jamie.getHitPoints());
	}
	/**
	 * Test for pick and drop of a weapon
	 */
	@Test
	public void testPickAndDropWeapon()
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		LifeForm jamie = new MockLifeForm("Jamie", 30, 5);
		Weapon sword = new MockWeapon("Sword");
		Weapon spear = new MockWeapon("Spear");
		dungeon.addItem(1, 1, sword, 1);
		dungeon.addLifeForm(1, 1, jamie);
		jamie.pickUpWeapon(sword);
		assertEquals(sword, jamie.getWeapon());
		
		jamie.dropWeapon();
		assertNull(jamie.getWeapon());
		// Already when weapon is there it doesnt pick up another
		dungeon.addItem(2, 2, sword, 0);
		dungeon.addItem(2, 2, spear, 1);
		jamie.pickUpWeapon(sword);
		jamie.pickUpWeapon(spear);
		assertEquals(sword,jamie.getWeapon());
	}
}
