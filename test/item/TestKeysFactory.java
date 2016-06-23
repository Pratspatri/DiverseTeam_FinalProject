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
	 * Test the Key Factory and make sure to create the key and it will pass positive number only 
	 * as numbers for keys 
	 */
	@Test
	public void testKeyFactory() {
		
		
		equals(KeyFactory.KeysFactory(1) instanceof Keys);
		
		// to check if negative number is passed ,  and the expected method is null
		assertNull(KeyFactory.KeysFactory(-1));
		
		
		
	}

}
