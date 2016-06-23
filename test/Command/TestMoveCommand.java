package Command;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * Test move Command class
 * @author Saad
 *
 */
public class TestMoveCommand {
	
	
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

	/**
	 * Test the Initialization of the command 
	 */
	@Test
	public void testInitialization() {
		
		LifeForm life = new MockLifeForm("Bob", 50, 10);
		Command move = new MoveCommand(life);
		assertTrue(move instanceof MoveCommand);
		
	}
	
	/**
	 * Test the life form is moving north 
	 */
	@Test
	public void testExecuteMoveNorthCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm life = new MockLifeForm("Bob", 50, 10);
		Command move = new MoveCommand(life);
		//add life form 
		den.addLifeForm(1, 1, life); 
		//Set the life form to the west 
		life.SetDirection("west");
		String s = move.execute();
		assertEquals(s , "Move!");
		// check when the life form moved 
		assertEquals(life , den.getLifeForm(1, 0)); 
		
		 
		
		
		
		
	}
	
	/**
	 * Test the life form is moving east 
	 */
	
	@Test
	public void testExecuteastCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm life = new MockLifeForm("Bob", 50, 10);
		Command move = new MoveCommand(life);
		//add life form 
		den.addLifeForm(1, 1, life); 
		//Set the life form to the east 
		life.SetDirection("east");
		String s = move.execute();
		assertEquals(s , "Move!");
		// check when the life form moved 
		assertEquals(life , den.getLifeForm(1, 2));	
		
		
	}
	
	/**
	 * Test the life form is moving north 
	 */
	
	@Test
	public void testExecutNorthCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm life = new MockLifeForm("Bob", 50, 10);
		Command move = new MoveCommand(life);
		//add life form 
		den.addLifeForm(1, 1, life); 
		//Set the life form to the west 
		life.SetDirection("north");
		String s = move.execute();
		assertEquals(s , "Move!");
		// check when the life form moved 
		assertEquals(life , den.getLifeForm(0, 1));	
		
		
	}
	
	/**
	 * Test the life form is moving south 
	 */
	@Test
	public void testExecutSouthCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm life = new MockLifeForm("Bob", 50, 10);
		Command move = new MoveCommand(life);
		//add life form 
		den.addLifeForm(1, 1, life); 
		//Set the life form to the south 
		life.SetDirection("south");
		String s = move.execute();
		assertEquals(s , "Move!");
		// check when the life form moved 
		assertEquals(life , den.getLifeForm(2, 1));	
		
		
	}

}
