package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test for Goblin class which extends Creature
 * @author Prathyusha Akshintala
 * 
 */
public class TestGoblin 
{
	@Test
	public void testInitialization()
	{
		Creature griphook = new Goblin("Goblin", 50, 10);
		assertEquals("Goblin",griphook.getDescription());
		assertEquals(50,griphook.getLifePoints());
		assertEquals(10,griphook.getStrength());
		griphook.setMaxLife(60);
		assertEquals(60,griphook.getMaxLife());
	}
}
