package lifeform;

import exception.RecoveryException;
import recovery.Recovery;

/**
 * Abstract class for the creature which extends LifeForm
 * @author Prathyusha Akshintala
 *
 */
public abstract class Creature extends LifeForm
{
	private int maxLife;
	
	protected String description;
	
	protected Recovery recoveryBehavior;
	
	private int rateOfRecovery;
	
	public Creature(String name, int life, int strength) 
	{
		super(name, life, strength);
		recoveryBehavior = null;
		maxLife = lifePoints;
	}
	
	public Creature(String name, int life, int strength, Recovery rec)
	{
		super(name, life, strength);
		recoveryBehavior = rec;
	}

	public Creature(String name, int life, int strength, Recovery rec, int rateOfRecovery) throws RecoveryException
	{
		this(name, life, strength, rec);
		if (rateOfRecovery >= 0)
		{
			this.rateOfRecovery = rateOfRecovery;
		}
		else
		{
			throw new RecoveryException("Recovery Rate can not be less than 0");
		}
	}	
	
	public int getMaxLife() 
	{
		return maxLife;
	}

	public void setMaxLife(int maxLife) 
	{
		this.maxLife = maxLife;
	}

}
