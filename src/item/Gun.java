package item;

/**
 * One of weapon type
 * @author Malak
 *
 */
public class Gun extends Weapon 
{
	/**
     * Decide the behavior of damage
     */
    protected Damage damage;
	
	/**
	 * Constructor send the damage behavior
	 * @param damage
	 */
	public Gun(Damage damage)
	{  
		baseDamage=15;
	    maxRange=30;
		this.damage=damage;
		description="gun";
	}
	
	/**
	 * calculate damage based on behavior of damage
	 * @param distance
	 */
	public void calculateDamage(int distance)
	{
		damage.calculateDamage(distance, maxRange, baseDamage);
	}

}
