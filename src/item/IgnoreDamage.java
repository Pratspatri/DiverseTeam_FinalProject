package item;

/**
 * This class will decorator the armor, so player can ignore damage,so
 * playe's armor points will remain unchanged
 * @author Malak
 *
 */
public class IgnoreDamage extends AbilityArmor 
{
	/**
	 * Constructor
	 */
	public IgnoreDamage()
	{
		description="ignore";
	}
	@Override
	public void useArmor(int distance) 
	{
		// TODO Auto-generated method stub

	}
}
