package item;

/**
 * This class decorator the armor's type then treat them as an armor
 * 
 * @author Malak
 *
 */
public abstract class AbilityArmor extends SpecialArmor 
{
	/**
	 * Define description
	 */
	public String description;
	/**
	 * Define an instance variable from specialArmor which is abstract class
	 */
	protected SpecialArmor specialArmor;

	/**
	 * Save the healthy state after uding the armor
	 */
	public String healthState;

	/**
	 * set description for a armor
	 * 
	 * @param description
	 */
	@Override
	public void setDescription(String description) 
	{
		this.description = description;
	}

	/**
	 * get description
	 */
	@Override
	public String getDescription() 
	{
		return description;
	}

	/**
	 * set healthy state to player
	 */
	public void setHealthState(String state) 
	{
		healthState = state;
	}

	/**
	 * get healthy state to player
	 */
	public String getHealthState() 
	{
		return healthState;
	}

}
