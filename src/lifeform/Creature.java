package lifeform;

import ability.Ability;
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
	
	public abstract String getDescription();
	
	public void setCurrentLife(int lifePoints)
	{
		if (lifePoints < maxLife)
		{
			this.lifePoints = (lifePoints >= 0) ? lifePoints : 0;
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
	
	
	public void recover()
	{
		if (recoveryBehavior != null)
		{
			int life = recoveryBehavior.calculateRecovery(lifePoints, maxLife);
			setCurrentLife(life);
		}
	}

	public int getRecoveryRate()
	{
		return rateOfRecovery;
	}

	public void setRecoveryRate(int recoveryRate) throws RecoveryException
	{
		if (recoveryRate >= 0)
		{
			this.rateOfRecovery = recoveryRate;
		}
		else
		{
			throw new RecoveryException("Recovery Rate can not be less than 0");
		}
	}

	@Override
	public void takeHit(LifeForm lifeform, int damage) 
	{
		if(damage > 0)
		{
				lifePoints -= damage;
				lifePoints=(lifePoints<0)?0:lifePoints;
		}
	}

	/**
	 * When the time is changed the timer notifies this method.
	 * @param time : updated time
	 */
	@Override
	public void updateTime(int time)
	{
		if (rateOfRecovery != 0 && (time) % rateOfRecovery == 0)
		{
			recover();
		}
	}
	
	public int calculateDamage()
	{
		return strength;
	}
}
