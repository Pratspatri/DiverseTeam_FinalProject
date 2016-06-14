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
	public float damage;
	/**
	 * calculate damage for sword and spear weapon
	 */
	@Override
	public int calculateDamage(int distance,float maxRange,float baseDamage) 
	{
	    damage=baseDamage*(distance+5);
		return (int) damage;
	}



}
