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
     * There different use for the armor
     */
    public abstract void useArmor();
}
