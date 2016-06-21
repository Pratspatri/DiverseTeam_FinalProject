package item;

import lifeform.Player;

/**
 * This class is for taken a good potions
 * @author Malak
 *
 */
public class Healing implements AffectBehavior
{   
	/**
     *Define the amount of potions 
     */
	public int amount;

	/**
	 * Implement the taken to increase the ability of player
	 * Increase the ability of player by increase strength by the amount which the player drinks
	 */

	@Override
	public int taken(int amounts) 
	{
		amount=amounts+3;
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
	
    /**
     * display the beavior 
     */
	@Override
	public String display()
	{
		
		return "Healing";
	}
}
