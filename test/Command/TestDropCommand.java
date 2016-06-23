package Command;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;
import item.Armor;
import item.Item;
import item.MockArmor;
import item.MockItem;
import item.MockWeapon;
import item.Weapon;
import lifeform.Player;

/**
 * Test Drop Class 
 * @author Saad
 *
 */
public class TestDropCommand {
	

	/**
	 * Clear all the LifeForms and Items  in the Dungeon before each test. 
	 */
	@Before
	public void resetDungonBefore() {
		Dungeon.resetInstance();
	} 
	
	/**
	 * Clear all the LifeForms and Items  in the Dungeon after all tests. 
	 */
	@After
	public void resetDungonBeAfter() {
		Dungeon.resetInstance();
	}  
	
	@Test
	public void testInitialization()
	{
		Player player =(Player) Player.getPlayerInstance(); 
		Command drop = new DropCommand();
		assertTrue(drop instanceof Command);
	} 
	
	/**
	 * Test the execute method for Drop Command and make sure that will call the correct Command  
	 */
	@Test
	public void testDropExecute()
	{
		/**
		 * Check if the player drop a weapon
		 */
		Dungeon den = Dungeon.getDungeonInstance();
		Player player =(Player) Player.getPlayerInstance(); 
		den.addLifeForm(0, 0, player );
		Command drop = new DropCommand();
		
		
		assertTrue(drop instanceof Command);
          // add Weapon to the  player inventory 
		Weapon item = new MockWeapon("sharp"); 
		Weapon item2 = new MockWeapon("sharp2");
		den.addItem(0, 0, item2, 1);
		player.pickUpWeapon(item); 
		
		//Check that the cell will be null
		assertNull(den.getItem(0,0 , 0));    
		// Drop the item 
		String s = drop.execute();
		assertEquals(s, "the item has been droped");
        assertEquals(item , den.getItem(0, 0, 0));		
   
        
        /**
         * Check if the player drop an armor 
         */
       
		Player player2 =(Player) Player.getPlayerInstance(); 
		den.addLifeForm(1, 1, player2 );
		Command drop2 = new DropCommand();
		
		
		assertTrue(drop instanceof Command);
          // add Weapon to the  player inventory 
		Armor arm = new MockArmor("sharp"); 
		Armor arm2 = new MockArmor("sharp");
		den.addItem(0, 0, arm2, 1);
		player2.setArmor(arm); 
		
		//Check that the cell will be null
		assertNull(den.getItem(1,1 , 0));   
		
		// Drop the item 
		String ss = drop.execute();
		assertEquals(ss, "the item has been droped"); 
        assertEquals(arm , den.getItem(1, 1, 0)); 
   	
		
	}
	
	
	
	

}
