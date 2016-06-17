package ability;

public class MockAbility extends Ability 
{

	public MockAbility(String name, int life, int strength) 
	{
		super(name, life, strength);
	}

	@Override
	public String getDescription() 
	{
		return null;
	}

	@Override
	public int calculateDamage(int damage) 
	{
		return 0;
	}

}
