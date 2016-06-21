package item;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test all methods on Keys class
 * @author Malak
 *
 */
public class TestKeys 
{
    
	/**
     * Create an object form Keys class
     */
	@Test
	public void TestInitialization()
	{
		Item key= new Keys(1);
		equals(key instanceof Keys);	
	}
	/**
     *Test setKeys and getKeys
     */
	@Test
	public void TestSetGetKey()
	{
		Keys key =new Keys(5);
		assertEquals(5,key.getKey());
		key.setKey(10);
		assertEquals(10,key.getKey());
		
	}

}
