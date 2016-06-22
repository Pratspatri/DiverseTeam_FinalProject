package item;

/**
 * One of weapon type
 * @author Malak
 *
 */
public class Sword extends Weapon
{   
	/**
	 * Constructor send the damage behavior
	 * @param damage
	 */
	public Sword()
	{   
		 baseDamage=10;
		 maxRange=3;
		description="sword";
	}
	
	/**
	 * calculate damage based on behavior damage
	 * @param distance
	 */
	public int calculateDamage(int distance)
	{   
		if(distance<=maxRange)
		{
			damage=baseDamage+(distance+10);
			setDamage(damage);
		}
		
		return (int) damage;
	}
}
