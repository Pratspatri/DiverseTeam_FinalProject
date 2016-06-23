package Command;

import static org.junit.Assert.*;


import org.junit.Test;
import dungeon.Dungeon;
import item.GenericItem;
import item.Item;
import item.MockItem;
import item.MockWeapon;
import item.Weapon;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import lifeform.Player;



/**
 * Test 
 * @author Saad
 *
 */

public class TestAcquireCommand {

	
	/**
	 * Test the Initialization  
	 */
	@Test
	public void testInitialization() {
		
		Player life =(Player) Player.getPlayerInstance(); 
		Command acquire = new AcquireCommand ();
		assertTrue(acquire instanceof Command);
		
	}
	
	/**
	 * Method to test Acquire Command and make sure that will call the Write Command . will be tow items 
	 * in one cell in slot 2 and in slot 1 
	 */
	@Test
	public void testExcutetMethod() {
		Dungeon den = Dungeon.getDungeonInstance();
		Player life =(Player) Player.getPlayerInstance(); 
		equals(life instanceof Player);
		assertTrue(life instanceof Player);
		//add life form to the cell 
		den.addLifeForm(0, 0, life); 
		
		
		Command acquire = new AcquireCommand ();
		assertTrue(acquire instanceof Command);
		
		//add item to the cell
		Weapon item = new MockWeapon("waepon");
		den.addItem(0, 0, item, 0);
	    // check the command 
		String s = acquire.execute();
		
		assertEquals(s,"Item has been picked up."); 
	    assertEquals(item , life.getItemFromInventory(0));
	    assertNull(den.getItem(0, 0, 0));
	    
	    
	    /**
	     * Test the if there is one item in slot1 
	     */
		
		Item item2 = new MockItem("potion");
		den.addItem(0, 0, item2 , 1);
		// Calling the Acquire command 
		String m = acquire.execute();
		//Check the correct results 
		assertEquals(m,"Item has been picked up."); 
	    assertEquals(item2 , life.getItemFromInventory(1));
	    assertNull(den.getItem(0, 0, 1));
	    
	    
	    
	    
	    
		
		
        		
	}

}
