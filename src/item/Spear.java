package item;

/**
 * One of weapon type
 * @author Malak
 *
 */
public class Spear extends Weapon 
{
	/**
     * Decide the behavior of damage
     */
    protected Damage damage;
	
	/**
	 * Constructor send the damage behavior
	 * @param damage
	 */
	public Spear(Damage damage)
	{
		this.damage=damage;
		description="spear";
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
