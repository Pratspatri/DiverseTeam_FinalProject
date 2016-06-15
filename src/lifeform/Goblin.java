package lifeform;

import exception.RecoveryException;
import recovery.Recovery;

/**
 * Creature subclass - Goblin
 * @author Prathyusha Akshintala
 */
public class Goblin extends Creature 
{

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
	
	@Override
	public String getDescription() 
	{
		return "Goblin";
	}	
}
