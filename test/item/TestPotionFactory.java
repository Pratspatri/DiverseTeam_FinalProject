package item;

import static org.junit.Assert.*;


import org.junit.Test;

import lifeform.CreatureFactory;
import lifeform.Goblin;

/**
 * Potion Factory test 
 * @author Saad
 *
 */

public class TestPotionFactory {

	/**
	 * Test Potion Factory and make sure will return the correct instance by sending the correct 
	 * type 
	 * 
	 */
	@Test
	public void testPotionFactory() {
		// make sure will create AntiParalysis object
		equals(PotionFactory.PotionsFactory("AntiParalysis" ) instanceof AntiParalysis);
		// make sure will create AntiPoison object
		equals(PotionFactory.PotionsFactory("AntiPoison" ) instanceof AntiPoison);
		// make sure will create AlihotsyDraught object
		equals(PotionFactory.PotionsFactory("AlihotsyDraught" ) instanceof AlihotsyDraught); 
		
		/**
		 * Test AntiParalysis potions 
		 */
		PotionFactory factor = new PotionFactory();
		// Create new potion 
		Potions potion = factor.PotionsFactory("AntiParalysis");
		assertTrue(potion instanceof Potions);
		
		
		// Check if it is the correct instance 
		potion.setAmount(10);
		assertEquals(10 , potion.getAmount());
		
		/**
		 * Test AntiPoison potion 
		 */
		Potions potion2 = factor.PotionsFactory("AntiPoison");
		assertTrue(potion2 instanceof Potions);
		potion2.setAmount(15);
		assertEquals(15 , potion2.getAmount());
		/**
		 * Test AlihotsyDraught potion 
		 */
		
		Potions potion3 = factor.PotionsFactory("AlihotsyDraught");
		assertTrue(potion3 instanceof Potions); 
		potion3.setAmount(20);
		assertEquals(20 , potion3.getAmount());
		
	}

}
