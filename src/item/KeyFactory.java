package item;

import java.awt.RenderingHints.Key;
/**
 * The class represent the factory pattern . in this class the keys will be created  
 * @author Saad
 *
 */

public class KeyFactory {


	/**
	 * Create new keys objects with its number. 
	 * @param number that will be add as number of the key 
	 * @return null if the number is null 
	 * @return new object of key ife the object is created 
	 */
	
	public static  Keys KeysFactory(int number)
	{
		// the key number should be bigger than zero 
		if(number < 0)
		{
			return null ; 
		}
		return new Keys(number);
	}

}
