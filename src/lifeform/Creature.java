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
	private int maxLife;											// maximum life points for creature
	
	protected String description;									// description of creature
	
	protected Recovery recoveryBehavior;							// recovery behavior - None & Linear
	
	private int rateOfRecovery;										// rate of recovery for creature
	
	// Constructor
	public Creature(String name, int life, int strength) 
	{
		super(name, life, strength);
		recoveryBehavior = null;
		maxLife = lifePoints;
		rateOfRecovery = 0;
	}
	//Constructor with recovery
	public Creature(String name, int life, int strength, Recovery rec)
	{
		super(name, life, strength);
		recoveryBehavior = rec;
	}
	//Constructor with rate of recovery and throws exception
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
	// Abstract method for subclasses to implement and get description
	public abstract String getDescription();
	/**
	 * @author Prathyusha Akshintala
	 * Sets current life points
	 * @param lifePoints
	 */
	public void setCurrentLife(int lifePoints)
	{
		if(lifePoints > 0)
		{
			if (lifePoints < maxLife)
			{
				this.lifePoints = (lifePoints >= 0) ? lifePoints : 0;
			}
			else
			{
				this.lifePoints = maxLife;
			}
		}
		else
		{
			this.lifePoints = 0;
		}
		
	}
	/**
	 * @author Prathyusha Akshintala
	 * gets Max life points
	 * @return
	 */
	public int getMaxLife() 
	{
		return maxLife;
	}
	/**
	 * @author Prathyusha Akshintala
	 * sets max life points
	 * @param maxLife
	 */
	public void setMaxLife(int maxLife) 
	{
		this.maxLife = maxLife;
	}
	/**
	 * @author Prathyusha Akshintala
	 * recover method for creature 
	 */
	public void recover()
	{
		if (recoveryBehavior != null)
		{
			int life = recoveryBehavior.calculateRecovery(lifePoints, maxLife);
			setCurrentLife(life);
		}
	}
	/**
	 * @author Prathyusha Akshintala
	 * gets recovery rate
	 * @return
	 */
	public int getRecoveryRate()
	{
		return rateOfRecovery;
	}
	/**
	 * @author Prathyusha Akshintala
	 * sets recovery rate - none or linear
	 * @param recoveryRate
	 * @throws RecoveryException
	 */
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
	/**
	 * @author Prathyusha Akshintala
	 * take hit method for creature
	 */
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
	 * @author Prathyusha Akshintala
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
	/**
	 * @author Prathyusha Akshintala
	 * calculates damage for the creature
	 * @return
	 */
	public int calculateDamage()
	{
		return strength;
	}
}
