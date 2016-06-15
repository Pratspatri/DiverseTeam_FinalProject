package ability;
/**
 * Class for poison ability
 * @author Prathyusha Akshintala
 *
 */
public class Poison extends Ability
{

	public Poison(String name, int life, int strength) 
	{
		super(name, life, strength);
	}

	/**
	 * gets the description
	 */
	@Override
	public String getDescription() 
	{
		return "Poison";
	}

	/**
	 * calculates damage
	 */
	@Override
	public int calculateDamage(int damage) 
	{
		return (damage+10);
	}
}
