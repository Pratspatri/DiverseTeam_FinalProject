package item;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Keys Factory test class 
 * @author Saad
 *
 */

public class TestKeysFactory {

	/**
	 * Test the Key Factory and make sure to ceate the key 
	 */
	@Test
	public void testKeyFactory() {
		KeyFactory facotr = new KeyFactory();
		//Create the key with key number 
		Keys key = facotr.KeysFactory(4);
		// check if the key is ceated 
		assertEquals(key.getKey() , 4);
		
		KeyFactory facotr2 = new KeyFactory();
		//Create the key with key number 
		Keys key2 = facotr.KeysFactory(5);
		// check if the key is ceated 
		assertEquals(key2.getKey() , 5);
		
		/**
		 * Check if it is smaller than Zero . it will return null 
		 */
		
		KeyFactory facotr3 = new KeyFactory();
		assertNull(facotr3.KeysFactory(-3));
		
		
		
	}

}
