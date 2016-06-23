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
	 * @author Prathyusha Akshintala
	 * gets the description
	 */
	@Override
	public String getDescription() 
	{
		return "Poke";
	}

	/**
	 * @author Prathyusha Akshintala
	 * calculates damage
	 */
	@Override
	public int calculateDamage() 
	{
		return (creature.calculateDamage()+5);
	}
}
