package ability;

public class Poke extends Ability
{

	public Poke(String name, int life, int strength)
	{
		super(name, life, strength);
	}

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
