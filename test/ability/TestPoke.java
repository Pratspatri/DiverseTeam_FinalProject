package ability;

import static org.junit.Assert.*;
import lifeform.Creature;
import lifeform.Goblin;

import org.junit.Test;

/**
 * Test for Poke class which is also an ability for the creature
 * @author Prathyusha Akshintala
 *
 */
public class TestPoke 
{
	@Test
	public void testInitialization()
	{
		Creature griphook = new Goblin("Goblin",40,5);
		Ability poke = new Poke(griphook);
		assertEquals(10,poke.calculateDamage());
		assertEquals("Poke",poke.getDescription());
	}
}
