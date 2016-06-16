package item;

import lifeform.Player;

/**
 * This class is for taken a bad potions
 * @author Malak
 *
 */
public class NoHealing extends Potions
{
    /**
     * Constructor
     */
	public NoHealing(int quantity) 
	{
		amount=quantity;
	}
	/**
	 * override the taken to decrease the ability of player
	 * Increase the ability of player by increasing the hitpoints and decreasing strength and Experience point by the amount which the player drinks
	 */
	@Override
	public void taken() 
	{
		Player.getPlayerInstance().setStrength(Player.getPlayerInstance().getStrength()+amount);
		((Player) Player.getPlayerInstance()).setHealth("Not Healed");
	}

}
