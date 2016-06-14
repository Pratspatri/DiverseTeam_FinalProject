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
		baseDamage=7;
		 maxRange=5;
		this.damage=damage;
		description="spear";
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
