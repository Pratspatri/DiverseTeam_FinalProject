package ability;

public class MockAbility extends Ability 
{
	// As mock ability extends ability which in turn extends creature, same constructor
	public MockAbility(String name, int life, int strength) 
	{
		super(name, life, strength);
	}

	/**
	 * Gets the description
	 */
	@Override
	public String getDescription() 
	{
		return null;
	}

	/**
	 * Calculates the damage
	 */
	@Override
	public int calculateDamage() 
	{
		return 0;
	}

}
