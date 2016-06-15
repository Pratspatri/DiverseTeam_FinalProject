package ability;

public class Poke extends Ability
{

	@Override
	public String getDescription() 
	{
		return "Poke";
	}

	@Override
	public int calculateDamage(int damage) 
	{
		return (damage+5);
	}

}
