package lifeform;

import exception.RecoveryException;
import recovery.Recovery;

/**
 * Creature subclass - Goblin
 * @author Prathyusha Akshintala
 */
public class Goblin extends Creature 
{
	/**
	 * @author Prathyusha Akshintala
	 * @param name
	 * @param life
	 * @param strength
	 */
	// Goblin extends creature. Therefore its constructors have to be implemented.
	public Goblin(String name, int life, int strength) 
	{
		super(name, life, strength);
	}

	public Goblin(String name, int life, int strength, Recovery rec) 
	{
		super(name, life, strength, rec);
	}
	
	public Goblin(String name, int life, int strength, Recovery rec, int rateOfRecovery) throws RecoveryException 
	{
		super(name, life, strength, rec, rateOfRecovery);
	}
	/**
	 * @author Prathyusha Akshintala
	 * gets the description of creature
	 */
	@Override
	public String getDescription() 
	{
		return "Goblin";
	}	
}
