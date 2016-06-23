package lifeform;

import recovery.Recovery;
import exception.RecoveryException;

/**
 * Creature class - Mummy
 * @author Prathyusha Akshintala
 */
public class Mummy extends Creature 
{
	/**
	 * @author Prathyusha Akshintala
	 * @param name
	 * @param life
	 * @param strength
	 */
	// Because it extends creature, constructors and unimplemented methods are added here
	public Mummy(String name, int life, int strength) 
	{
		super(name, life, strength);
	}

	public Mummy(String name, int life, int strength, Recovery rec) 
	{
		super(name, life, strength, rec);
	}
	
	public Mummy(String name, int life, int strength, Recovery rec, int rateOfRecovery) throws RecoveryException 
	{
		super(name, life, strength, rec, rateOfRecovery);
	}
	/**
	 * @author Prathyusha Akshintala
	 * Gets the description of creature
	 */
	@Override
	public String getDescription() 
	{
		return "Mummy";
	}
}
