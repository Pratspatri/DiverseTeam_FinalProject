package item;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * Potion Factory test 
 * @author Saad
 *
 */

public class TestPotionFactory {

	/**
	 * Test Potion Factory and make sure will return the correct instance
	 * 
	 */
	@Test
	public void testPotionFactory() {
		
		/**
		 * Test Pokimon potions 
		 */
		PotionFactory factor = new PotionFactory();
		// Create new potion 
		Potions potion = factor.PotionFactory("Pokimon");
		assertTrue(potion instanceof Potions);
		
		
		// Check if it is the correct instance 
		potion.setAmount(10);
		assertEquals(10 , potion.getAmount());
		
		/**
		 * Test Mega potion 
		 */
		Potions potion2 = factor.PotionFactory("Mega");
		assertTrue(potion2 instanceof Potions);
		potion2.setAmount(15);
		assertEquals(15 , potion2.getAmount());
		/**
		 * Test Ultra potion 
		 */
		
		Potions potion3 = factor.PotionFactory("Ultra");
		assertTrue(potion3 instanceof Potions);
		potion3.setAmount(20);
		assertEquals(20 , potion3.getAmount());
		
	}

}
