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
	
	/**
	 * Constructor send the damage behavior
	 * @param damage
	 */
	public Gun()
	{  
		baseDamage=15;
	    maxRange=30;
	    rate_of_Fire=4;
	    max_Ammo=40;
	    actual_ammo=max_Ammo;
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
	 * GetRateofFire set rate of fire
	 */
	public float gettRateofFire()
	{
	    return	rate_of_Fire;
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
		if(distance<=maxRange && actual_ammo>0)
		{
			damage=baseDamage+(distance/maxRange);
			setDamage(damage);
		}
		fire();
		return (int) damage;
	}
    


}
