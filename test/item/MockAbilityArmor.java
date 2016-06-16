package item;

/**
 * Purpose of this class is to test all methods in AbilityArmor which is abstract class
 * @author Malak
 *
 */
public class MockAbilityArmor extends AbilityArmor
{
    /**
     * Constructor
     */
	public MockAbilityArmor(SpecialArmor specialArmor) 
	{
		super.specialArmor=specialArmor;
		super.description=specialArmor.getDescription();
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
