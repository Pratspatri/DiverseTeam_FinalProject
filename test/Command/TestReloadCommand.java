package Command;

import static org.junit.Assert.*;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import item.Gun;
import item.Weapon;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import Command.Command;
/**
 * Test Class to test the reload command 
 * @author Saad
 *
 */

public class TestReloadCommand {

	/**
	 * This method tests the reload Command and make sure that will call the correct
	 * Command  
	 */
	@Test
	public void testExcuteMethod() {
		LifeForm life = new MockLifeForm("Bob", 10, 10);
		Weapon wp = new Gun();
		Command reload = new ReloadCommand(life);
		assertTrue(reload instanceof Command);
		equals(wp instanceof Gun);
		// Pick up the weapon 
		life.pickUpWeapon(wp);
		assertEquals(40,((Gun) wp).getActualAmmo(),.1);
		// call the fire method 
		wp.calculateDamage(10);
		assertEquals(39 , ((Gun) wp).getActualAmmo(),.1);
		//Set the actual method to zero to check the reload method 
		((Gun) wp).setActualAmmo(0);
		//Call the execute command of the reload 
		String s = reload.execute();
		assertEquals("The Weapon has been reloaded!" , s);
		/**
		 * the excepted result is 40
		 */
		assertEquals(40, ((Gun) wp).getActualAmmo(),.1);
		
		
		
		
		
	}

}
