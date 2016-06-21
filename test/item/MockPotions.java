package item;

/**
 * Purpose of this class is to test all methods in Potions which is abstract class
 * @author Malak
 *
 */
public class MockPotions extends Potions
{
    /**
     * Constructor
     */
	public MockPotions(int amount) 
	{
		super.amount=amount;
		affect = new Healing();
	}
    /**
     * Implements taken method
     */
}
