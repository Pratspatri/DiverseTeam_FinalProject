package item;

/**
 * Purpose of this class is to test all methods in DamageDecorator  which is abstract class
 * @author Malak
 *
 */
public class MockDamageDecorator extends DamageDecorator 
{
    /**
     * Constructor
     */
	public MockDamageDecorator(Weapon weopon) 
	{
		super.weapon=weapon;

	}
     
    /**
     * Implement calculateDamage()
     */
	@Override
	public int calculateDamage(int distance) 
	{
		// TODO Auto-generated method stub
		return 0;
	}
    
	   /**
     * Implement getDescription()
     */
	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
