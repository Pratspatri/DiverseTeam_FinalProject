package ability;

import lifeform.Creature;

public abstract class Ability extends Creature
{
	public Ability(String name, int life, int strength) 
	{
		super(name, life, strength);
	}

	protected Creature creature;
	
	public abstract String getDescription();
	
	public abstract int calculateDamage(int damage);
}
