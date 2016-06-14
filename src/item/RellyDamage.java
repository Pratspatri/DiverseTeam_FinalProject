package item;

/**
 * Describe the behavior for Gun weapon 
 * @author Malak
 *
 */
public class RellyDamage implements Damage 
{
	float rate_of_Fire;
	float max_Ammo;
	float actual_ammo;
	
	
	/**
	 * implement setMaxAmmo() to set max ammo
	 */
	public void setMaxAmmo(float maxAmmo)
	{
		 max_Ammo=maxAmmo;
		
	}
	/**
	 * implement setActualAmmo() to set actual
	 */
	public void setActualAmmo(float ammo)
	{
		actual_ammo = ammo;
	}
	/**
	 * implement setRateofFire set rate of fire
	 */
	public void setRateofFire(float rateFire)
	{
		rate_of_Fire=rateFire;
	}
	
	/**
	 * implement getMaxAmmo() to get max ammo
	 */
	public float getMaxAmmo()
	{
		return max_Ammo;	
	}
	/**
	 * implement getActualAmmo() to get actual ammo
	 */
	public float getActualAmmo()
	{
		return actual_ammo;
	}
	/**
	 * Implement reload()for reload the ammo
	 */
	public void reload()
	{
	if(actual_ammo==0)
		setActualAmmo(max_Ammo);
	
	}
	/**
	 * Implement RateOfFire() to manage the rate of fire in each round
	 */

	public void fire()
	{
	if(rate_of_Fire>0)
		{
		rate_of_Fire--;
		actual_ammo--;
		}
	}

	@Override
	public void calculateDamage(int distance) {
		// TODO Auto-generated method stub

	}

}
