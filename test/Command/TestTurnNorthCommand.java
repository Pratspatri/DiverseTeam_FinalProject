package Command;

import static org.junit.Assert.*;


import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;
/**
 * turn north Command class Test 
 * @author Saad
 *
 */

public class TestTurnNorthCommand {

	
	/**
	 * Test The initialization of the command 
	 */
	@Test
	public void testinitialization() 
	{
		
		
		LifeForm life = new MockLifeForm("Bob", 10, 10);	
		Command north = new TurnNorthCommand(life); 
		
		assertTrue(north instanceof TurnNorthCommand ); 
		
	}
	
	/**
	 * Test method to ensure that will call the correct command  
	 */
	@Test
	public void testExecuteNorthCommand() 
	{
		
		
		LifeForm life = new MockLifeForm("Bob", 10, 10);
		life.SetDirection("north");
		Command north = new TurnNorthCommand(life);
		
		String s = north.execute();
		assertEquals(s , "Turn North!");
		assertEquals(0,life.getDirection().compareToIgnoreCase("north"));
		
	} 

}
