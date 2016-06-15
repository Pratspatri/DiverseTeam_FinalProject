package item;

/**
 * Describe the behavior for Gun weapon 
 * @author Malak
 *
 */
public class RellyDamage extends DamageDecorator
{
	/**
     * Calculate damage
     */
    float damage;
	
/**
 * Make the damage four time
 */
	@Override
	public int calculateDamage(int distance) 
	{
		damage=weapon.calculateDamage(distance)*4;
		return (int) damage;
	}



}
