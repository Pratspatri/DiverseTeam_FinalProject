package lifeform;

public class MockCreature extends Creature 
{

	public MockCreature(String name, int life, int strength) 
	{
		super(name, life, strength);
	}

	@Override
	public String getDescription() 
	{
		return null;
	}

}
