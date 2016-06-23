package ability;

import static org.junit.Assert.*;
import lifeform.Creature;
import lifeform.Mummy;

import org.junit.Test;

/**
 * Test for Poison class which is an ability and decorate the creatures
 * @author Prathyusha Akshintala
 *
 */
public class TestPoison 
{
	/**
	 * Test for Initialization
	 * @author Prathyusha Akshintala
	 */
	@Test
	public void testInitialization()
	{
		Creature mummy = new Mummy("Mummy", 50, 10);
		Ability poi = new Poison(mummy);
		assertEquals(20,poi.calculateDamage());
		assertEquals("Poison",poi.getDescription());
	}
}
