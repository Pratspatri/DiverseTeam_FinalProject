package Command;

import static org.junit.Assert.*;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;


/**
 * turn east Command class Test 
 * @author Saad
 *
 */
public class TestTurnEastComand {

	

		/**
		 * Test The initialization of the command 
		 */
		@Test
		public void testInitialization() 
		{
			
			
			LifeForm life = new MockLifeForm("Bob", 10, 10);	
			Command east = new TurnEastCommand(life); 
			
			assertTrue(east instanceof TurnEastCommand ); 
			
		}
		
		/**
		 * Test method to ensure that will call the turn east command  
		 */
		@Test
		public void testExecuteEastCommand() 
		{
			
			
			LifeForm life = new MockLifeForm("Bob", 10, 10);	
			Command east = new TurnEastCommand(life); 
			life.SetDirection("east");
			
			
			String s = east.execute();
			assertEquals(s , "Turn East!");
			assertEquals(0,life.getDirection().compareToIgnoreCase("east"));
			
		} 

	}

