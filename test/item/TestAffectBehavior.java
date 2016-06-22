package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test all methods in MockAffectBehavior
 * @author Malak
 *
 */
public class TestAffectBehavior 
{

	/**
     * Test Initialization to create an object from MockAffectBehavior
     */
	@Test
	public void TestInitialization() 
	{
		AffectBehavior mock=new MockAffectBehavior();
		assertTrue(mock instanceof MockAffectBehavior);
		mock.setAmount(5);
		assertEquals(5,mock.getAmount());
		mock.taken(10);
		assertEquals(13,mock.getAmount());
	}

}
