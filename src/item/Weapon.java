package item;

public abstract class Weapon extends GenericItem
{
	float baseDamage;
	float maxRange;
    String description;
    protected Damage damage;
	
	public void setBaseDamge(float base_Damage)
	{
		baseDamage=base_Damage;
	}
	
	/**
	 * implement setMaxrRange() set max range
	 */ 
	public void setMaxrRange(float max_Range)
	{
		 maxRange=max_Range;
	}
	
	/**
	 * implement getBaseDamge() to get base damage
	 */
	public float getBaseDamge()
	{
		return baseDamage;
		
	}
	/**
	 * implement getMaxrRange() to get max range
	 */
	public float getMaxrRange()
	{
		return maxRange;
	}
	/**
	 * Set description to weapon 
	 */
	public void setDescribtion (String description)
	{
		this.description=description;
	}
	
	/**
	 * Set description to weapon 
	 */
	public String getDescribtion ()
	{
		return description;
	}
	
	/**
	 * Prathyusha
	*/
		public static int fire(int distance) 
		{
			return 0;
		}

		public static int getActualAmmo() 
		{
			return 0;
		}

		public void reload() 
		{
			
		}

		public int getMaxRange() 
		{
			return 0;
		}

}
