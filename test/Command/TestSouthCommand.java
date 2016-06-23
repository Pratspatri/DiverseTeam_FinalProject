package Command;

import static org.junit.Assert.*;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * Turn South test class 
 * @author Saad
 *
 */
public class TestSouthCommand {

	
	/**
	 * Test the Initialization of the command 
	 */
	@Test
	public void testInitialization() {
		
		LifeForm life = new MockLifeForm("Bob", 10, 10);
		Command south = new TurnSouthCommand(life);
		assertTrue(south instanceof TurnSouthCommand);
		
		
	}
	
	
	/**
	 * Test the Initialization of the command 
	 */
	@Test
	public void testExecuteMethod() {
		
		LifeForm life = new MockLifeForm("Bob", 10, 10);
		Command south = new TurnSouthCommand(life);
		
		// Call the method 
		String s = south.execute(); 
		assertEquals(s , "Turn South!");
		
		
		assertEquals(0,life.getDirection().compareToIgnoreCase("south")); 
		
		
	}

}
