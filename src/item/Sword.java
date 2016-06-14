package item;

/**
 * One of weapon type
 * @author Malak
 *
 */
public class Sword extends Weapon
{
    /**
     * Decide the behavior of damage
     */
	protected Damage damage;
	
	/**
	 * Constructor send the damage behavior
	 * @param damage
	 */
	public Sword(Damage damage)
	{
		this.damage=damage;
		description="sword";
	}
	
	/**
	 * calculate damage based on behavior damage
	 * @param distance
	 */
	public void calculateDamage(int distance)
	{
		damage.calculateDamage(distance, distance, distance);
	}
}
