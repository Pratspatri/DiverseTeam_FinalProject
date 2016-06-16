package item;

/**
 * Purpose of this class is  to test all concert methods in Weapon class
 * @author Malak
 *
 */
public class MockWeapon extends Weapon 
{
     /**
      * Constructor
      * @param name
      */
	public MockWeapon(String name) 
	{
		description=name;
	}
     
	/**
	 * calculate Damage that is caused by a weapon
	 */
	@Override
	public int calculateDamage(int distance) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
