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
		
		LifeForm life = new MockLifeForm("Bob", 10, 10);
		Command acquire = new AcquireCommand ();
		assertTrue(acquire instanceof Command);
		
	}
	
	/**
	 * Method to test Acquire Command and make sure that will call the Write Command 
	 */
	@Test
	public void testExcutetMethod() {
		Dungeon den = Dungeon.getDungeonInstance();
		
		Player life =(Player) Player.getPlayerInstance();
		equals(life instanceof Player);
		assertTrue(life instanceof Player);
		den.addLifeForm(0, 0, life);
		
		
		Command acquire = new AcquireCommand ();
		assertTrue(acquire instanceof Command);
		
		
		Weapon item = new MockWeapon("waepon");
		den.addItem(0, 0, item, 0);
	
		String s = acquire.execute();
		
		assertEquals(s,"Item has been picked up.");
	    
		
		
		
		
        		
	}

}
