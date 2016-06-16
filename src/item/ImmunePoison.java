package item;

import lifeform.Player;

/**
 * This class will decorator the armor, so player can immune from poison
 * @author Malak
 *
 */
public class ImmunePoison extends AbilityArmor 
{
	/**
	 * Constructor
	 */
	public ImmunePoison(SpecialArmor specialArmor)
	{
		description="immunepoison";
		super.specialArmor=specialArmor;
	}
	/**
	 * Use Armor to ignore Damage
	 */
	@Override
	public int useArmor(int hit_damage) 
	{
         damage=0;
		return damage;

	}

}
