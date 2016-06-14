package item;

/**
 * This class is for taken a bad potions
 * @author Malak
 *
 */
public class NoHealing extends Potions
{
    /**
     * Constructor
     */
	public NoHealing(int quantity) 
	{
		amount=quantity;
	}
	/**
	 * override the taken to decrease the ability of player
	 */
	@Override
	public void taken() 
	{
		// TODO Auto-generated method stub

	}

}
