package item;

import lifeform.Player;

/**
 * This class is for taken a good potions
 * @author Malak
 *
 */
public class Healing extends Potions 
{
	/**
	 * Constructor
	 * @param quantity
	 */
	public Healing(int quantity) 
	{ 
		amount=quantity;
	}

	/**
	 * override the taken to increase the ability of player
	 * Increase the ability of player by decreasing the hitpoints and increase strength and Experience point by the amount which the player drinks
	 */
	@Override
	public void taken() 
	{
		Player.getPlayerInstance().setStrength(Player.getPlayerInstance().getStrength()+amount);
	}

}
