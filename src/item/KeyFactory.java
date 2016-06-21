package item;

import java.awt.RenderingHints.Key;
/**
 * Keys Factrory Class 
 * @author Saad
 *
 */

public class KeyFactory {
	/**
	 *This method creats new Keys 
	 * @param number
	 * @return
	 */
	
	public Keys KeysFactory(int number)
	{
		// the key number should be bigger than zero 
		if(number < 0)
		{
			return null ; 
		}
		return new Keys(number);
	}

}
