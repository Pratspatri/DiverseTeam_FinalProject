package item;

import lifeform.Player;

/**
 * This class will decorator the armor, so player can ignore damage,so
 * playe's armor points will remain unchanged
 * @author Malak
 *
 */
public class IgnoreDamage extends AbilityArmor 
{
	/**
	 * Constructor
	 */
	public IgnoreDamage()
	{
		description="ignore";
	}
	/**
	 * Use Armor to ignore Damage
	 */
	@Override
	public void useArmor(int distance) 
	{
		Player.getPlayerInstance().setLifePoints(Player.getPlayerInstance().getLifePoints());

	}
}
