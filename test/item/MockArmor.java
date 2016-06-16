package item;
/**
 * Purpose of this class is to test all methods in Armor which is abstract class
 * @author Malak
 *
 */
public class MockArmor extends Armor 
{ 
	/**
	 * Constructor
	 */
	public MockArmor(String name) 
	{
		description=name;
	}
    /**
     * Calculate damage when player has armor
     */
	@Override
	public int useArmor(int hit_damage) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
