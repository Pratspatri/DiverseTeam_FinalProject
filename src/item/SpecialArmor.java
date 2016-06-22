package item;

/**
 * It is one of armor type which does have ability
 * 
 * @author Malak
 *
 */
public abstract class SpecialArmor extends Armor 
{
	/**
	 * Describe the armor type
	 */
	public String description;

	/**
	 * set description for a armor
	 * 
	 * @param description
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}

	/**
	 * get description for a armor
	 * 
	 * @return description
	 */
	public String getDescription() 
	{
		return description;
	}

}
