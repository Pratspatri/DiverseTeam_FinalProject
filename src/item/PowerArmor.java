package item;

/**
 * It is one of special armor type 
 * @author Malak 
 *
 */
public class PowerArmor extends SpecialArmor 
{   
	/**
	 * Constructor
	 */
	public PowerArmor()
	{
		description="powerArmor";
		armorPoints=40;
	}

	@Override
	public int useArmor(int distance) 
	{
		return damage;
		// TODO Auto-generated method stub

	}

}
