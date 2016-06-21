package item;

import lifeform.Player;

/**
 * This class is for taken a bad potions
 * @author Malak
 *
 */
public class NoHealing implements AffectBehavior
{
	/**
     *Define the amount of potions 
     */
	public int amount;

	/**
	 * override the taken to decrease the ability of player
	 * Increase the ability of player by decreasing strength and Experience point by the amount which the player drinks
	 */

	@Override
	public int taken(int amounts) 
	{
		amount=amounts-3;
		setAmount(amount);
		return getAmount() ;
	}
	
	/**
	 * Implement set amount of potions
	 * @return
	 */
	@Override
	public void setAmount(int amounts) 
	{
		amount=amounts;
	}
	
	/**
	 * Implement get the amount 
	 */
	@Override
	public int getAmount() 
	{
		
		return amount;
	}
}
