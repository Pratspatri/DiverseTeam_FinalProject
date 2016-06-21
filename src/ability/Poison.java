package ability;

import lifeform.Creature;

/**
 * Class for poison ability
 * @author Prathyusha Akshintala
 *
 */
public class Poison extends Ability
{
	// Poison also extends ability which extends creature
	public Poison(Creature creature) 
	{
		super(creature);
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
	public int calculateDamage() 
	{
		return (creature.calculateDamage()+10);
	}
}
