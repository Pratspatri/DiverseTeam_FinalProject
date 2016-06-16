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
     * Constructor
     */
    public RellyDamage(Weapon weapon)
    {
    	super.weapon=weapon;
    }
    
	/**
	 * Make the damage four time
	 */
	@Override
	public int calculateDamage(int distance) 
	{
		damage=weapon.calculateDamage(distance)*4;
		return (int) damage;
	}
	/**
     * get description 
     */
	@Override
	public String getDescription()
	{
		description="really damage";
		return description;
	}

}
