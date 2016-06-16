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
     * Constructor
     */
    public AlittleDamage(Weapon weapon)
    {
    	super.weapon=weapon;
    }
	/**
	 * calculate damage to make it double
	 */
	@Override
	public int calculateDamage(int distance) 
	{
	    damage=weapon.calculateDamage(distance)*2;
		return (int) damage;
	}
     /**
      * get description 
      */
	@Override
	public String getDescription()
	{
		description="Alittle damage";
		return description;
	}




}
