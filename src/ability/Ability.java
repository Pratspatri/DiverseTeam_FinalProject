package ability;
/**
 * Abstract class for ability
 * @author - Prathyusha Akshintala
 */
import lifeform.Creature;

public abstract class Ability extends Creature
{
	public Ability(String name, int life, int strength) 
	{
		super(name, life, strength);
	}

	protected Creature creature;
	// abstract method to get the description
	public abstract String getDescription();
	// abstract method to calculate damage
	public abstract int calculateDamage(int damage);
}
