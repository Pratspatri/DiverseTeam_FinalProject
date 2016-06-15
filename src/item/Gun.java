package item;

/**
 * One of weapon type
 * @author Malak
 *
 */
public class Gun extends Weapon 
{

	float rate_of_Fire;
	float max_Ammo;
	float actual_ammo;
	float damage;
	/**
	 * Constructor send the damage behavior
	 * @param damage
	 */
	public Gun()
	{  
		baseDamage=15;
	    maxRange=30;
		description="gun";
	}
	
	/**
	 * setMaxAmmo() to set max ammo
	 */
	public void setMaxAmmo(float maxAmmo)
	{
		 max_Ammo=maxAmmo;
		
	}
	/**
	 *  setActualAmmo() to set actual
	 */
	public void setActualAmmo(float ammo)
	{
		actual_ammo = ammo;
	}
	/**
	 * setRateofFire set rate of fire
	 */
	public void setRateofFire(float rateFire)
	{
		rate_of_Fire=rateFire;
	}
	
	/**
	 * getMaxAmmo() to get max ammo
	 */
	public float getMaxAmmo()
	{
		return max_Ammo;	
	}
	/**
	 * getActualAmmo() to get actual ammo
	 */
	public float getActualAmmo()
	{
		return actual_ammo;
	}

	/**
	 * reload()for reload the ammo
	 */
	
	public void reload() 
	{
		if(actual_ammo==0)
			setActualAmmo(max_Ammo);
		
	}
	
	/**
	 * fire() to manage the rate of fire in each round
	 */

	public void fire() 
	{
		if(rate_of_Fire>0)
		{
		rate_of_Fire--;
		actual_ammo--;
		}
		
	}
	/**
	 * calculate damage based on behavior of damage
	 * @param distance
	 */
	public int calculateDamage(int distance)
	{
		damage=baseDamage*(distance/maxRange);
		return (int) damage;
	}
    


}
