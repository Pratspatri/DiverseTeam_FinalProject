package lifeform;

import exception.RecoveryException;
import recovery.Recovery;

public class MockCreature extends Creature 
{

	public MockCreature(String name, int life, int strength) 
	{
		super(name, life, strength);
	}

	public MockCreature(String name, int life, int strength, Recovery rec) 
	{
		super(name, life, strength, rec);
	}

	public MockCreature(String name, int life, int strength, Recovery rec, int rateOfRecovery) throws RecoveryException 
	{
		super(name, life, strength, rec, rateOfRecovery);
	}

	@Override
	public String getDescription() 
	{
		return null;
	}

}
