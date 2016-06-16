package item;

/**
 * One of weapon type
 * @author Malak
 *
 */
public class Spear extends Weapon 
{
	/**
	 * Constructor send the damage behavior
	 * @param damage
	 */
	public Spear()
	{   
		baseDamage=7;
		 maxRange=5;
		description="spear";
	}
	
	/**
	 * calculate damage based on behavior of damage
	 * @param distance
	 */
	public int calculateDamage(int distance)
	{    
		if(distance<=maxRange)
		{
			damage=baseDamage*(distance+10);
			setDamage(damage);
		}
		return (int) damage;
		
	}
}
