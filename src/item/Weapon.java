package item;

/**
 * This class which is an abstract is related to the weapon item which includes
 * common methods and variables in all weapon type
 * @author Malak
 *
 */
public abstract class Weapon extends GenericItem
{   /**
     *Define base Damage
     */
	float baseDamage;
	
	/**
	 * Define max range
	 */
	float maxRange;
	
	/**
	 * Define description to weapon
	 */
    String description;
    
    /**
     * Calculate damage
     */
    float damage;
  
    /**
	 * Allowed to get max range
	 */
	public void setBaseDamge(float base_Damage)
	{
		baseDamage=base_Damage;
	}
	
	/**
	 * Allowed to set max range
	 */ 
	public void setMaxrRange(float max_Range)
	{
		 maxRange=max_Range;
	}
	
	/**
	 * Allowed to get base damage
	 */
	public float getBaseDamge()
	{
		return baseDamage;
		
	}
	
	/**
	 * Allowed to get max range
	 */
	public float getMaxrRange()
	{
		return maxRange;
	}
	/**
	 * Allowed to set description to weapon 
	 */
	public void setDescribtion (String description)
	{
		this.description=description;
	}
	
	/**
	 * Allowed to set description to weapon 
	 */
	public String getDescribtion ()
	{
		return description;
	}
	
	/**
	 * Set Damage 
	 */
	public void setDamage(float damages)
	{
		damage=damages;
	}
	
	/**
	 * get Damge 
	 */
	public int getDamage()
	{
		return (int) damage;
	}
	/**
	 * Calculate damage for each weapon 
	 */
	
	public abstract int calculateDamage(int distance);
	
}
