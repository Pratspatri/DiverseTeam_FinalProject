package item;

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
	public IgnoreDamage(SpecialArmor specialArmor)
	{
		description="ignore";
		super.specialArmor=specialArmor;
	}
	/**
	 * Use Armor to ignore Damage
	 */
	@Override
	public int useArmor(int hit_damage) 
	{
		damage=specialArmor.useArmor(hit_damage);
		setDamageArmor(damage);
		setHealthState("Protected");
		return damage;

	}
}
