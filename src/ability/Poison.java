package ability;

public class Poison extends Ability
{

	public Poison(String name, int life, int strength) 
	{
		super(name, life, strength);
	}

	@Override
	public String getDescription() 
	{
		return "Poison";
	}

	@Override
	public int calculateDamage(int damage) 
	{
		return (damage+10);
	}
}
