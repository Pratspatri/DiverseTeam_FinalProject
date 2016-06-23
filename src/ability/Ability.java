package ability;
/**
 * Abstract class for ability
 * @author - Prathyusha Akshintala
 */
import lifeform.Creature;

public abstract class Ability extends Creature
{
	// Similar constructor as that of creature because ability extends it
	public Ability(String name, int life, int strength) 
	{
		super(name, life, strength);
	}
	public Ability(Creature creature)
	{
		this(creature.getName(),creature.getLifePoints(),creature.getStrength());
		this.creature=creature;
	}
	// @author Prathyusha Akshintala
	// This follows decorator pattern - so we need to make this variable protected
	protected Creature creature;
	// abstract method to get the description
	public abstract String getDescription();
	// abstract method to calculate damage
	public abstract int calculateDamage();
	
	
}
