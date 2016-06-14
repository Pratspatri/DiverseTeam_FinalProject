package item;

/**
 * This class decorator the armor's type then treat them as an armor
 * @author Malak
 *
 */
public abstract class AbilityArmor extends SpecialArmor 
{
	public String description;
	protected SpecialArmor specialArmor;
	@Override
	public void setDescription(String description)
	{
		this.description=description;
	}
	@Override
	public String getDescription()
	{
		return description;
	}
	

}
