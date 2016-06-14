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
		this.damage=damage;
		description="gun";
	}
	
	/**
	 * calculate damage based on behavior damage
	 * @param distance
	 */
	public void calculateDamage(int distance)
	{
		damage.calculateDamage(distance);
	}

}
