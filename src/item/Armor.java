package item;

/**
 * Determine how resistant a player to damage
 * @author Malak
 *
 */
public abstract class Armor extends GenericItem
{
	/**
	 * how many points in the armor
	 */
    public int armorPoints;
    
    /**
	 * Calculate Damage
	 */
       public int damage;
    
    /**
	 * set description for a armor
	 * @param description
	 */
	public String description;
    
    /**
     * set the points to armor
     * @param armorPoints
     */
    public void setArmorPoints(int armorPoints)
    {
    	this.armorPoints=armorPoints;
    }
    
    /**
     * get how many points in armor
     * @return
     */
    public int getArmorPoints()
    {
    	return armorPoints;
    }
    /**
     * set description for a armor
     * @param description
     */
    public void setDescription(String description)
    {
    	this.description=description;
    }

    /**
     * get description for a armor
     * @return description
     */
    public String getDescription()
    {
    	return description;
    }
    /**
     * There different use for the armor
     */
    public abstract int useArmor(int hit_damage);
}
