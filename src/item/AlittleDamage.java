package item;

/**
 * Describe the behavior for Sword and Spear weapon 
 * @author Malak
 *
 */
public class AlittleDamage extends DamageDecorator 
{
	/**
     * Calculate damage
     */
    float damage;
    
	/**
	 * calculate damage to make it double
	 */
	@Override
	public int calculateDamage(int distance) 
	{
	    damage=weapon.calculateDamage(distance)*2;
		return (int) damage;
	}

	@Override
	public String getDescription()
	{
		description="really damage";
		return description;
	}




}
