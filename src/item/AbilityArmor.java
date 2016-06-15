package item;

/**
 * This class decorator the armor's type then treat them as an armor
 * @author Malak
 *
 */
public abstract class AbilityArmor extends SpecialArmor 
{   /**
     *Define description 
     */
	public String description;
	/**
	 * Define an instance variable from specialArmor which is abstract class
	 */
	protected SpecialArmor specialArmor;
	
	 /**
     * set description for a armor
     * @param description
     */
	@Override
	public void setDescription(String description)
	{
		this.description=description;
	}
	
	/**
     * get description 
     */
	@Override
	public String getDescription()
	{
		return description;
	}
	

}
