package item;

/**
 * Describe the behavior for Sword and Spear weapon 
 * @author Malak
 *
 */
public class AlittleDamage implements Damage 
{
    /**
     * Store damage result
     */
	public int damage;
	/**
	 * calculate damage for sword and spear weapon
	 */
	@Override
	public int calculateDamage(int distance, int maxRange, int baseDamage) 
	{
	    damage=baseDamage*(distance+5);
		return damage;
	}



}
