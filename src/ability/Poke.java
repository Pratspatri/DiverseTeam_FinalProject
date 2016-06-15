package ability;
/**
 * Class for poke ability
 * @author Prathyusha Akshintala
 *
 */
public class Poke extends Ability
{

	public Poke(String name, int life, int strength)
	{
		super(name, life, strength);
	}

	/**
	 * gets the description
	 */
	@Override
	public String getDescription() 
	{
		return "Poke";
	}

	/**
	 * calculates damage
	 */
	@Override
	public int calculateDamage(int damage) 
	{
		return (damage+5);
	}
}
