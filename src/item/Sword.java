package item;

/**
 * One of weapon type
 * @author Malak
 *
 */
public class Sword extends Weapon
{   
	/**
     * Calculate damage
     */
    float damage;
	/**
	 * Constructor send the damage behavior
	 * @param damage
	 */
	public Sword()
	{   
		 baseDamage=9;
		 maxRange=3;
		description="sword";
	}
	
	/**
	 * calculate damage based on behavior damage
	 * @param distance
	 */
	public int calculateDamage(int distance)
	{
		damage=baseDamage*(distance+10);
		return (int) damage;
	}




}
