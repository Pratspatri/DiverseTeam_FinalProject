package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Creature Factory Class 
 * @author Saad
 *
 */
public class TestCreatureFactory { 

	/**
	 * Test The Initialization and create an object from Goblin and create Class from Mummy 
	 */
	@Test
	public void testInitialization() 
	{
		//Goblin Object
		equals(CreatureFactory.CreaturesFactory("Goblin" , "goblin" , 10 , 10 ) instanceof Goblin);  
		// Mummy Object
		equals(CreatureFactory.CreaturesFactory("Mummy" , "mum" , 10 , 10 ) instanceof Mummy); 
		
	}

}
