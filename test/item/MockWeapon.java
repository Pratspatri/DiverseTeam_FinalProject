package item;

public class MockWeapon extends Weapon {
     /**
      * Constructor
      * @param name
      */
	public MockWeapon(String name) 
	{
		description=name;
	}

	@Override
	public int calculateDamage(int distance) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
