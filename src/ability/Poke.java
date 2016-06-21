package ability;

import lifeform.Creature;

/**
 * Class for poke ability
 * @author Prathyusha Akshintala
 *
 */
public class Poke extends Ability
{
	// Constructor for Poke - This extends Ability which in turn extends Creature. 
	public Poke(Creature creature)
	{
		super(creature);
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
