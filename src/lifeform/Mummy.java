package lifeform;

import recovery.Recovery;
import exception.RecoveryException;

/**
 * Creature class - Mummy
 * @author Prathyusha Akshintala
 */
public class Mummy extends Creature 
{
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
	
	@Override
	public String getDescription() 
	{
		return "Mummy";
	}
}
