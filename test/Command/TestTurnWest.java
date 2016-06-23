package Command;

import static org.junit.Assert.*;
import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;


/**
 * Turn West Command test Class
 * @author Saad
 *
 */
public class TestTurnWest {

	
	/**
	 * Test The initialization of the command 
	 */
	@Test
	public void testInitialization() {
		LifeForm life = new MockLifeForm("Bob", 50, 10);
		Command west = new TurnWestCommand(life);
		assertTrue(west instanceof TurnWestCommand);
	}
	
	
	/**
	 * Test method to ensure that will call the west command   
	 */
	@Test
	public void testExecuteWestCommand() 
	{
		
		
		LifeForm life = new MockLifeForm("Bob", 10, 10);
		life.SetDirection("west");
		Command west = new TurnWestCommand(life);
		
		String s = west.execute();
		assertEquals(s , "Turn West!");
		assertEquals(0,life.getDirection().compareToIgnoreCase("west"));
		
	}

}
