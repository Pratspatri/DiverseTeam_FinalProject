package item;

/**
 * Purpose of this class is to test all methods in SpecialArmor which is abstract class
 * @author Malak
 *
 */
public class MockSpecialArmor extends SpecialArmor 
{

	public MockSpecialArmor(String name) 
	{
		super.description=name;
	}

	/**
     * Implement useArmor()
     */
	@Override
	public int useArmor(int hit_damage) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
