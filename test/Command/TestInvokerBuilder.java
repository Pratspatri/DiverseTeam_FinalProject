package Command;

import static org.junit.Assert.*;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;
import Command.MoveCommand;

/**
 * Invoker Builder Class Test 
 * @author Saad
 *
 */
public class TestInvokerBuilder {

	/**
	 * Test the initialization and make sure that each command will attach to the write receiver
	 * the Commands are (attack , drop , move , reload , turn east , turn west , turn south , turn north)
	 */
	@Test
	public void testInitialization() { 


		LifeForm life = new MockLifeForm("Bob",10, 10);
		InvokerBuilder builder = new InvokerBuilder();
		
		Invoker invoker = builder.getInvoker(life);
		
		// Check each command 
		assertTrue(invoker.AttackCm instanceof AttackCommand);
		
		assertTrue(invoker.DropCm instanceof DropCommand);
		
		assertTrue(invoker.AcquireCm instanceof AcquireCommand);
		
		assertTrue(invoker.reloadCm instanceof ReloadCommand);
		
		assertTrue(invoker.MoveCm instanceof MoveCommand);
		
		assertTrue(invoker.TurnEastCm instanceof TurnEastCommand);
		
		assertTrue(invoker.TurnWestCm instanceof TurnWestCommand);
		
		assertTrue(invoker.TurnNourthCm instanceof TurnNorthCommand);
		
		assertTrue(invoker.TurnSouthCm instanceof TurnSouthCommand);
		
		
		
		
		
		
		
		
	}

}
