package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for the Mummy class which extends Creature
 * @author Prathyusha Akshintala
 *
 */
public class TestMummy
{
	@Test
	public void testInitialization()
	{
		Creature mummy = new Mummy("Mummy", 50, 10);
		assertEquals("Mummy",mummy.getDescription());
		assertEquals(50,mummy.getLifePoints());
		assertEquals(10,mummy.getStrength());
		mummy.setMaxLife(60);
		assertEquals(60,mummy.getMaxLife());
	}
}
