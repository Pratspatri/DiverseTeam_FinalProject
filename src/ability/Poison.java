package ability;

public class Poison extends Ability
{

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
